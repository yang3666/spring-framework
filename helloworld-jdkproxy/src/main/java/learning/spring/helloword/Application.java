package learning.spring.helloword;

import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args) {
        Hello original = new SpringHello();
        //通过Proxy.newProxyInstance()为Hello实现类的Bean实例创建使用LogHandler的代理
        Hello target = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), original.getClass().getInterfaces(), new LogHandler(original));
        target.say();
    }

}
