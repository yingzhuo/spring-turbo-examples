package spring.turbo.examples;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.bean.*;

import java.io.Serializable;

@RestController
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @PostMapping
    public String test(@RequestBody Request request) {
        System.out.println(request.getDayRange());
        System.out.println(request.getNumberPair());
        System.out.println(request.getShortPair());
        System.out.println(request.getBytePair());
        System.out.println(request.getIntegerPair());
        System.out.println(request.getLongPair());
        System.out.println(request.getBigIntegerPair());
        System.out.println(request.getFloatPair());
        System.out.println(request.getDoublePair());
        System.out.println(request.getBigDecimalPair());
        System.out.println(request.getDatePair());
        return "ok";
    }

    @Getter
    @Setter
    private static class Request implements Serializable {
        private DayRange dayRange;
        private NumberPair numberPair;
        private BytePair bytePair;
        private ShortPair shortPair;
        private IntegerPair integerPair;
        private LongPair longPair;
        private BigIntegerPair bigIntegerPair;
        private FloatPair floatPair;
        private DoublePair doublePair;
        private BigDecimalPair bigDecimalPair;
        private DatePair datePair;
    }

}
