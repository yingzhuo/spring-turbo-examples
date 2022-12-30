package examples.open_feign.feigncli;

import examples.open_feign.feigncli.ret.Contributor;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import spring.turbo.module.feign.FeignClient;
import spring.turbo.module.feign.annotation.DoNotCloseAfterDecode;
import spring.turbo.module.feign.annotation.EncoderAndDecoder;

import java.util.List;

@FeignClient(url = "https://api.github.com")
@EncoderAndDecoder(
        encoderType = JacksonEncoder.class,
        decoderType = JacksonDecoder.class
)
@DoNotCloseAfterDecode
public interface GitHub {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    public List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

}
