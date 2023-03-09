package examples.open_feign;

import examples.open_feign.feigncli.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private GitHub githubClient;

    public static void main(String[] args) {
        var app = new SpringApplication(ApplicationBoot.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        var contributors = githubClient.contributors("yingzhuo", "spring-turbo");

        for (var contributor : contributors) {
            System.out.println(contributor.getLogin());
        }
    }

}
