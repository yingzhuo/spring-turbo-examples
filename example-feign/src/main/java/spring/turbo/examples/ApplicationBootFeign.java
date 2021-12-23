package spring.turbo.examples;

import org.springframework.context.annotation.Configuration;
import spring.turbo.module.feign.EnableFeignClients;

@Configuration
@EnableFeignClients(basePackages = "spring.turbo.examples")
class ApplicationBootFeign {
}
