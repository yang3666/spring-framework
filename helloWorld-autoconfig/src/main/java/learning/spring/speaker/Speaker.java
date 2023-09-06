package learning.spring.speaker;

import org.springframework.stereotype.Component;

@Component("speaker")
public interface Speaker {
    String speak();
}
