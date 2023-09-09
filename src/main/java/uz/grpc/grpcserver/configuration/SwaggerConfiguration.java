package uz.grpc.grpcserver.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring/GRPC/WebFlux",
                description = "Spring Grpc-Webflux Application",
                contact = @Contact(
                        name = "Abbos",
                        email = "abbos.abdukhakimov@gmail.com",
                        url = "https://github.com/happyDuke96"
                ),
                version = "1.0.0"
        ))
@Configuration
public class SwaggerConfiguration {

}
