package com.jel.tech;

import com.jel.tech.config.MyConfig;
import com.jel.tech.config.MyConfig2;
import com.jel.tech.model.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:11
 **/
public class SpringTest {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);


    @Test
    public void testImport() {

        printBeans(context);
    }

    private void printBeans(AnnotationConfigApplicationContext configApplicationContext) {

        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String x : beanDefinitionNames) {
            System.out.println(x);
        }
    }


    @Test
    public void fun3() {

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        System.out.println(Arrays.asList(beanNamesForType)); // [person, bill, linus]

        Map<String, Person> map = context.getBeansOfType(Person.class);
        System.out.println(map);
        /**
         * running result:
         *  {person=Person{name='ls', age=19}, bill=Person{name='bill gates', age=64}, linus=Person{name='Linus', age=50}}
         */

        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property); // Mac OS X
    }

    @Test
    public void fun2() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
//        Object person = context.getBean("person");
//        Object person2 = context.getBean("person");
//        System.out.println(person == person2); // true
    }

    @Test
    public void fun() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] names = context.getBeanDefinitionNames();
        System.out.println(Arrays.asList(names));
    }
}
