package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("FieldInjection.xml");
        //AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("ConstructorInjection.xml");
        //AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("SetterInjection.xml");
        Vehicle obj = (Vehicle) context.getBean("Vehicle");
        obj.drive();
        context.close();

        // BeanFactory
    }
}
