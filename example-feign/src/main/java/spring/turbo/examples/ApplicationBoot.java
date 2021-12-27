package spring.turbo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.turbo.examples.client.PetClient;

import java.util.Collections;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private PetClient petClient;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        petClient.getAll("jwt", Collections.emptyMap()).forEach(System.out::println);
    }

}
