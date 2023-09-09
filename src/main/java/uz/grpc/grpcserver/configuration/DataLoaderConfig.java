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
import uz.grpc.grpcserver.domain.Branch;
import uz.grpc.grpcserver.domain.Region;
import uz.grpc.grpcserver.repository.RegionRepository;
import uz.grpc.grpcserver.service.BranchService;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "faker", name = "enabled", havingValue = "true")
@RequiredArgsConstructor
@EnableMongoRepositories
public class DataLoaderConfig implements CommandLineRunner {

    private final Faker faker;
    private final BranchService branchService;
    private final RegionRepository regionRepository;

    @Value("${faker.count}")
    private Integer count;

    @Override
    public void run(String... args) throws Exception {
        List<Region> allRegions = regionRepository.findAll().collectList().block(Duration.of(10000000L, ChronoUnit.SECONDS));
        Flux.range(0,count)
                .flatMap(value -> {
                    Branch pizzaBranchData = Branch.builder()
                            .street(faker.address().streetName())
                            .apartment(faker.address().buildingNumber())
                            .latitude(faker.address().latitude())
                            .longitude(faker.address().longitude())
                            .region(allRegions.get(new Random().nextInt(0,allRegions.size())))
                            .build();
                    return branchService.createBranch(pizzaBranchData);
                })
                .doOnNext(branch -> log.info("created data : {}",branch))
                .doOnError(ex -> log.error("Error on create data : {}",ex.getLocalizedMessage()))
                .doFinally(signalType -> log.info("mock data created successfully"))
                .subscribe();
    }
}
