package Assignment1;

import org.genspark.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Field.xml");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("Constructor.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("Setter.xml");
        Vehicle obj = (Vehicle) context.getBean("Vehicle");
        obj.drive();
        // BeanFactory
    }

}
