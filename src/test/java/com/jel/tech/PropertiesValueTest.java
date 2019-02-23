package com.jel.tech;

import com.jel.tech.config.MainConfigPropertyValues;
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
 * @create 2019-02-21 00:00
 **/
public class PropertiesValueTest {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigPropertyValues.class);


    @Test
    public void testImport() {

        printBeans(context);

        Person person = (Person) context.getBean("person");
        System.out.println(person);


        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }

    private void printBeans(AnnotationConfigApplicationContext configApplicationContext) {

        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String x : beanDefinitionNames) {
            System.out.println(x);
        }
    }

}
