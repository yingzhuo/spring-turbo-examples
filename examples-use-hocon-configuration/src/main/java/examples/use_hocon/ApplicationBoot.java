package examples.use_hocon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import spring.turbo.module.configuration.env.HoconPropertySourceFactory;

@SpringBootApplication
@PropertySource(
        value = "classpath:config/other.conf",
        factory = HoconPropertySourceFactory.class
)
public class ApplicationBoot implements ApplicationRunner {

    @Value("${hello.world}")
    private String helloWorld;

    @Value("${a.b.c}")
    private String c;

    public static void main(String[] args) {
        var app = new SpringApplication(ApplicationBoot.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("----");
        System.out.println(helloWorld);
        System.out.println(c);
        System.out.println("----");
    }

}
