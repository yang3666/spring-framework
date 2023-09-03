package learning.spring.helloworld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    //使用BeanFactory实现
    private BeanFactory beanFactory;

    //使用ApplicationContext实现
    private ApplicationContext applicationContext;

    private ClassPathXmlApplicationContext parentContext;
    private ClassPathXmlApplicationContext childContext;


    public static void main(String[] args) {
           /*//使用new关键字创建实例
        Hello hello = new Hello();
        System.out.println(hello.hello());*/

        //使用配置文件的方式创建实例
        Application application = new Application();
        application.sayHello();

        System.out.println("====================================");
        new Application().runTests();
    }

    public Application() {

        //使用BeanFactory
        /*beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)beanFactory);
        reader.loadBeanDefinitions("beans.xml");*/

        //使用ApplicationContext
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        parentContext = new ClassPathXmlApplicationContext("parent-beans.xml");
        childContext = new ClassPathXmlApplicationContext(new String[]{"child-beans.xml"}, true, parentContext);
        parentContext.setId("ParentContext");
        childContext.setId("ChildContext");

    }

    public void runTests() {
        testVisibility(parentContext,"parentHello");
        testVisibility(childContext,"parentHello");
        testVisibility(parentContext,"childHello");
        testVisibility(childContext,"childHello");
        testOverridden(parentContext,"hello");
        testOverridden(childContext,"hello");
    }

    private void testVisibility(ApplicationContext context, String beanName) {
        System.out.println(context.getId()+" can see "+beanName+" : "+context.containsBean(beanName));
    }

    private void testOverridden(ApplicationContext context,String beanName) {
        System.out.println("sayHello from "+context.getId()+":"+context.getBean(beanName,Hello.class).hello());
    }

    public void sayHello() {
        //使用BeanFactory
//        Hello hello = beanFactory.getBean("hello", Hello.class);

        //使用ApplicationContext
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());
    }
}

