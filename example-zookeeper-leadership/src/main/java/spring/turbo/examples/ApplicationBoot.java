package spring.turbo.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.zookeeper.util.LeadershipUtils;

@RestController
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @GetMapping("/leadership")
    public String leadership() {
        return LeadershipUtils.hasLeadership() ?
                "Yeah! I am the leader of cluster!!!" :
                "I am a follower.";
    }

}
