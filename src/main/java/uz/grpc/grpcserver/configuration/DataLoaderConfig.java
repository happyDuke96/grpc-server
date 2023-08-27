package uz.grpc.grpcserver.configuration;


import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.grpc.grpcserver.domain.Address;
import uz.grpc.grpcserver.domain.District;
import uz.grpc.grpcserver.domain.Region;
import uz.grpc.grpcserver.domain.User;
import uz.grpc.grpcserver.repository.DistrictRepository;
import uz.grpc.grpcserver.repository.RegionRepository;
import uz.grpc.grpcserver.repository.UserRepository;

import java.util.stream.IntStream;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "faker", name = "enabled", havingValue = "true")
@RequiredArgsConstructor
@EnableMongoRepositories
public class DataLoaderConfig implements CommandLineRunner {

    private final Faker faker;
    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;

    @Value("${faker.count}")
    private Integer count;

    @Override
    public void run(String... args) throws Exception {
        Flux.range(0, count)
                .flatMap(value -> {
                    Region region = Region.builder()
                            .name(faker.address().cityName())
                            .isoCode(faker.address().citySuffix())
                            .build();
                    region = regionRepository.save(region).block();
                    District district = District.builder()
                            .name(faker.address().fullAddress())
                            .build();
                    User user = User.builder()
                            .name(faker.funnyName().name())
                            .lastName(faker.name().lastName())
                            .address(Address.builder()
                                    .street(faker.address().streetName())
                                    .house(faker.address().streetAddressNumber())
                                    .region(faker.address())
                                    .district(district)
                                    .build())
                            .build();
                    return userRepository.save(user);
                });
    }
}
