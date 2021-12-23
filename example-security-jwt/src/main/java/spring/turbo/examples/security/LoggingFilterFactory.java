package spring.turbo.examples.security;

import org.springframework.stereotype.Component;
import spring.turbo.module.security.FilterConfiguration;
import spring.turbo.module.security.filter.LoggingFilter;
import spring.turbo.util.LogLevel;
import spring.turbo.util.Logger;

@Component
class LoggingFilterFactory implements FilterConfiguration<LoggingFilter> {

    @Override
    public LoggingFilter create() {
        return new LoggingFilter(new Logger("请求", LogLevel.DEBUG));
    }

}
