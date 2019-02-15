package com.jel.tech.main;

import com.jel.tech.config.MyConfig;
import com.jel.tech.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author jelex.xu
 * @create 2019-02-15 23:58
 **/
public class Main {

    public static void main(String [] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        /**
         * running result:
         * Person{name='zs', age=18}
         */

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person); // Person{name='ls', age=19}

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        System.out.println(Arrays.asList(names)); // [person]
    }
}
