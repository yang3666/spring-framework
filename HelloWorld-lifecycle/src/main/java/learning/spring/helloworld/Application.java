package learning.spring.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean生命周期
 * spring Framework为我们提供了几种途径，在Bean创建后或销毁前增加某些操作
 * 1.实现InitializingBean和DisposableBean接口；
 * 2，使用JSR-250的@PostConstruct和@PreDestroy注解；
 * 在<bean/>或@Bean里配置初始化和销毁方法。
 */
@SpringBootApplication
public class Application {

    private ClassPathXmlApplicationContext applicationContext;

    public static void main(String[] args) {
        Application application = new Application();
        application.sayHello();
        application.close();

    }

    public Application() {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    public void sayHello() {
        Hello hello = (Hello)applicationContext.getBean("hello");
        System.out.println(hello.hello());
    }

    public void close() {
        applicationContext.close();
    }
}
