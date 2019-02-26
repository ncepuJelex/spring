package com.jel.tech;

import com.jel.tech.config.MainConfigAutowired;
import com.jel.tech.config.MainConfigProfile;
import com.jel.tech.model.Boss;
import com.jel.tech.model.Color;
import com.jel.tech.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:01
 **/
public class ProfileTest {

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
}
