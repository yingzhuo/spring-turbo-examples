package examples.versioned_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import spring.turbo.module.webmvc.requestcondition.VersionedRequestMappingHandlerMapping;
import spring.turbo.module.webmvc.version.ServletPathVersionResolver;

import java.util.List;

@Configuration
public class ApplicationBootWeb extends DelegatingWebMvcConfiguration {

    private final ObjectMapper objectMapper;

    public ApplicationBootWeb(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new VersionedRequestMappingHandlerMapping(new ServletPathVersionResolver());
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (var converter : converters) {
            if (converter instanceof AbstractJackson2HttpMessageConverter c) {
                c.setObjectMapper(objectMapper);
            }
        }
    }

}
