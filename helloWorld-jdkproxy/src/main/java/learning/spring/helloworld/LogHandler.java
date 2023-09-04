package learning.spring.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private Hello hello;

    public LogHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Ready to say somethiong.");
        try {
            return method.invoke(hello,args);
        }finally {
            System.out.println("Already say something");
        }
    }
}
