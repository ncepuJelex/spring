package com.jel.tech;

import com.jel.tech.config.MyConfig;
import com.jel.tech.config.MyConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:11
 **/
public class SpringTest {


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
