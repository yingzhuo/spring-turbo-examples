package examples.random_avatar_gen;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        var app = new SpringApplication(ApplicationBoot.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
