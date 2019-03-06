package com.jel.tech;

import com.jel.tech.aop.MathCalculator;
import com.jel.tech.config.MainConfigAOP;
import com.jel.tech.tx.TxConfig;
import com.jel.tech.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jelex.xu
 * @create 2019-02-27 10:56
 **/
public class TxTest {

    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService bean = context.getBean(UserService.class);
        bean.add();
    }
}
