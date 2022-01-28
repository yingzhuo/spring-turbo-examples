package spring.turbo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import spring.turbo.examples.domain.Cat;
import spring.turbo.examples.mixin.CatMixIn;
import spring.turbo.module.jackson.mixin.predefined.JsonMixIns;
import spring.turbo.webmvc.api.Json;

import java.util.Optional;

@Configuration
class ApplicationBootJackson {

    @Autowired
    void configObjectMapper(Optional<ObjectMapper> mapperOption) {
        mapperOption.ifPresent(om -> {
            om.addMixIn(Json.class, JsonMixIns.Style1.class);
            om.addMixIn(Cat.class, CatMixIn.class);
        });
    }

}
