package spring.turbo.examples;

import org.springframework.context.annotation.Configuration;
import spring.turbo.examples.client.PetClient;
import spring.turbo.module.feign.EnableFeignClients;

@Configuration
@EnableFeignClients(basePackageClasses = PetClient.class)
class ApplicationBootFeign {
}
