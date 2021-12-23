package spring.turbo.examples.client;

import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import spring.turbo.examples.model.Pet;
import spring.turbo.module.feign.FeignClient;
import spring.turbo.module.feign.annotation.EncoderAndDecoder;
import spring.turbo.module.feign.annotation.Logging;

import java.util.List;
import java.util.Map;

@FeignClient(url = "http://localhost:8080/pet")
@EncoderAndDecoder(encoderType = JacksonEncoder.class, decoderType = JacksonDecoder.class)
@Logging(level = Logger.Level.FULL, type = Slf4jLogger.class)
public interface PetClient {

    @RequestLine("GET")
    @Headers({
            "X-Token: {token}"
    })
    public List<Pet> getAll(@Param("token") String tokenValue, @QueryMap Map<String, Object> hello);

}
