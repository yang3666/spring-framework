package learning.spring.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

        //这会触发Lifecycle的start()
        applicationContext.start();

        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());

        //这会触发Lifecycle的stop()
        applicationContext.close();

        System.out.println(hello.hello());
    }

    @Bean
    public Hello hello() {
        return new Hello();
    }

}
