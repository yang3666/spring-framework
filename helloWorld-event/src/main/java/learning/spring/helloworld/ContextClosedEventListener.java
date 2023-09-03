package learning.spring.helloworld;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用ApplicationListener接口处理ContextClosedEvent事件的ContextClosedEventListener类代码片段
 */
@Component
@Order(1)
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("[ApplicationListener]ApplicationContext closed.");
    }
}
