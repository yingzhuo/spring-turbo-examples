package examples.open_feign;

import org.springframework.context.annotation.Configuration;
import spring.turbo.module.feign.EnableFeignClients;

@Configuration
@EnableFeignClients(basePackages = "examples.open_feign")
public class ApplicationBootFeign {
}
