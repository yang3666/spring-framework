package learning.spring.helloworld;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("learning.spring")
public class Config {

    @Bean
    @Lazy
    @Scope("prototype")
    public Hello helloBean() {
        return new Hello();
    }
}
