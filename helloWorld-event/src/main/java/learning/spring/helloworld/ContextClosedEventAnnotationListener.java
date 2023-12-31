package learning.spring.helloworld;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *用@EventListener注解处理ContextClosedEvent事件的ContextClosedEventAnnotationListener类代码
 */
@Component
public class ContextClosedEventAnnotationListener {

    @EventListener
    @Order(2)
    public void onEvent(ContextClosedEvent event) {
        System.out.println("[@EventListener]ApplicationContext closed.");
    }
}
