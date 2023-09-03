package learning.spring.helloworld;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * spring bean生命周期方法的执行顺序
 * 无论是初始化还是销毁。spring都会按照如下顺序依次进行调用
 * 1.添加了@PostConstruct或@PreDestroy的方法；
 * 2.实现了InitializingBean的afterPropertiesSet()方法，或DisposableBean的destroy()方法；
 * 3.在<bean/>中配置的init-method或destroy-method，@Bean中配置的initMethod或destroyMethod。
 *
 */
public class Hello implements DisposableBean {

    public String hello() {
        return "Hello World!";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory()");
    }

    public void close() {
        System.out.println("close()");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("shutdown()");
    }
}
