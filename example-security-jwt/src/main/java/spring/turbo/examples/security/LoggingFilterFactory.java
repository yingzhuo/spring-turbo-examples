package spring.turbo.examples.security;

import org.springframework.stereotype.Component;
import spring.turbo.module.security.FilterConfiguration;
import spring.turbo.module.security.filter.RequestLoggingFilter;
import spring.turbo.util.LogLevel;
import spring.turbo.util.Logger;

@Component
class LoggingFilterFactory implements FilterConfiguration<RequestLoggingFilter> {

    @Override
    public RequestLoggingFilter create() {
        return new RequestLoggingFilter(new Logger("请求", LogLevel.DEBUG));
    }

}
