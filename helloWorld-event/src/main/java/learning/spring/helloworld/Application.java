package learning.spring.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Application.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());

        applicationContext.getBean("customEventPublisher", CustomEventPublisher.class)
                .fire();
        applicationContext.close();
    }

}
