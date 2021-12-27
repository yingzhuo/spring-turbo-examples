package spring.turbo.examples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        final String password = ApplicationBoot.class.getName();
        log.debug("password = {}", password);
        log.debug("hashed password = {}", passwordEncoder.encode(password));
        log.debug("{}", passwordEncoder.matches(password, "{SM3}e20277c7e4b1e023b8e278f99898a39b1c4cf1a457c52926855a122244ede665"));
    }

}
