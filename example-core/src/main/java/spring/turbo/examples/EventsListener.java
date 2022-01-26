package spring.turbo.examples;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class EventsListener {

    @EventListener(ContextRefreshedEvent.class)
    public void onRefresh() {
    }

}
