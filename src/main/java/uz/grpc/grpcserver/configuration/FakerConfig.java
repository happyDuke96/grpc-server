package uz.grpc.grpcserver.configuration;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfig {
    @Value("${faker.locale}")
    private String locale;

    @Bean
    public Faker faker(){
        return new Faker(new Locale(locale));
    }
}
