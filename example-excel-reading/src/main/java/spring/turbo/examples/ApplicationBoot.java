package spring.turbo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import spring.turbo.examples.visitor.ExcelTypes;
import spring.turbo.module.excel.reader.BatchValueObjectReadingTrigger;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private BatchValueObjectReadingTrigger trigger;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        trigger.fire(ExcelTypes.USER, new ClassPathResource("user.xlsx"));
    }

}
