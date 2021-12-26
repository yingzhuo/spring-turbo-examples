package spring.turbo.examples.client;

import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import spring.turbo.module.feign.annotation.EncoderAndDecoder;
import spring.turbo.module.feign.annotation.Logging;
import spring.turbo.module.feign.annotation.Options;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EncoderAndDecoder(encoderType = JacksonEncoder.class, decoderType = JacksonDecoder.class)
@Logging(level = Logger.Level.FULL, type = Slf4jLogger.class)
@Options(connectTimeout = "2s")
public @interface ForAllClients {
}
