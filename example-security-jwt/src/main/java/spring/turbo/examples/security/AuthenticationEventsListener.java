package spring.turbo.examples.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.event.MaliciousRequestFailureEvent;
import spring.turbo.module.security.event.MaliciousRequestFailureEventUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
class AuthenticationEventsListener {

    // 监听恶意请求
    @EventListener
    public void onFailed(MaliciousRequestFailureEvent event) {
        final HttpServletRequest request = MaliciousRequestFailureEventUtils.getHttpServletRequest(event);
        if (request != null) {
            log.error("有恶意请求，令牌疑似被篡改: {}", request.getRequestURI());
        }
    }

}
