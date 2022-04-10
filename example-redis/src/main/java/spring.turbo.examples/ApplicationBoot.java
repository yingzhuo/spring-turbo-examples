package spring.turbo.examples;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.turbo.module.redis.util.LockUtils;

import java.util.UUID;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String uuid = UUID.randomUUID().toString();
        System.out.println(LockUtils.lock("hello", uuid, 10));
        System.out.println(LockUtils.release("hello", uuid));
    }

}
