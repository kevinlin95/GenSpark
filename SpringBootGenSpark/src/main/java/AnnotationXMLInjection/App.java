package AnnotationXMLInjection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Annotation.xml");
        Student obj = (Student) context.getBean("Student");
        context.close();
    }
}
