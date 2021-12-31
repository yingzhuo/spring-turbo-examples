package spring.turbo.examples.security;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.event.MaliciousRequestFailureEvent;

@Component
class AuthenticationEventsListener {

    // 监听恶意请求
    @EventListener
    public void onFailed(MaliciousRequestFailureEvent event) {
        System.out.println("出错了");
    }

}
