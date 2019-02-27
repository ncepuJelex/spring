package com.jel.tech;

import com.jel.tech.aop.MathCalculator;
import com.jel.tech.config.MainConfigAOP;
import com.jel.tech.config.MainConfigAutowired;
import com.jel.tech.model.Boss;
import com.jel.tech.model.Color;
import com.jel.tech.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jelex.xu
 * @create 2019-02-27 10:56
 **/
public class AOPTest {

    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAOP.class);

//        MathCalculator calculator = new MathCalculator();
        MathCalculator calculator = context.getBean(MathCalculator.class);
        calculator.div(10, 2);
        /**
         * running result:
         *      div start...,args-> {}div,,[10, 2]
                 div ends...
                div return...,result-> {}5
         */


        context.close();

    }
}
