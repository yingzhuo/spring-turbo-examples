package examples.spring_security_jwt.security;

import jakarta.servlet.Filter;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.filter.HumanReadableRequestLoggingFilter;
import spring.turbo.module.security.filter.RequestLoggingFilterFactory;

@Component
public class RequestLoggingFilterProvider implements RequestLoggingFilterFactory {

    @Override
    public Filter create() {
        var filter = new HumanReadableRequestLoggingFilter();
        return filter;
    }

}
