package com.jel.tech;

import com.jel.tech.aop.MathCalculator;
import com.jel.tech.config.MainConfigAOP;
import com.jel.tech.extension.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jelex.xu
 * @create 2019-03-12 10:48
 **/
public class ExtensionTest {

    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);


        context.publishEvent(new ApplicationEvent(new String("my event")) {
        });

        context.close();
    }
}
