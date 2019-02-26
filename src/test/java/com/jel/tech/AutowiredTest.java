package com.jel.tech;

import com.jel.tech.config.MainConfigAutowired;
import com.jel.tech.config.MainConfigLifeCycle;
import com.jel.tech.dao.PersonDao;
import com.jel.tech.model.Boss;
import com.jel.tech.model.Color;
import com.jel.tech.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:01
 **/
public class AutowiredTest {

    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAutowired.class);

        PersonService service = context.getBean(PersonService.class);

        service.print();

//        PersonDao personDao = context.getBean(PersonDao.class);
//        System.out.println(personDao);

        Boss boss = context.getBean(Boss.class);
        System.out.println(boss.getCar());

        Color color = context.getBean(Color.class);
        System.out.println(color.getCar());
    }
}
