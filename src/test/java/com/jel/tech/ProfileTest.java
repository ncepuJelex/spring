package com.jel.tech;

import com.jel.tech.config.MainConfigAutowired;
import com.jel.tech.config.MainConfigProfile;
import com.jel.tech.model.Boss;
import com.jel.tech.model.Color;
import com.jel.tech.model.Yellow;
import com.jel.tech.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:01
 **/
public class ProfileTest {

    /**
     * 1.vm运行参数中使用：spring.profiles.active=dev 来激活dev profile
     * -Dspring.profiles.active=dev
     *
     * 2. 看fun2()
     */
    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigProfile.class);

        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name : names) {
            System.out.println(name);
        }
        /**
         * running result:
         *  dsDev
            dsTest
            dsProd
         */
    }

    @Test
    public void fun2() {

        /**
         * 相当于调用有参构造，只是在里面设置环境
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(MainConfigProfile.class);
        context.refresh();

        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name : names) {
            System.out.println(name);
        }
        /**
         * running result:
         *  dsTest
         */
        Yellow yellow = context.getBean(Yellow.class);
        System.out.println(yellow);
    }
}
