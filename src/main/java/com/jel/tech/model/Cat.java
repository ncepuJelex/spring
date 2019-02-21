package com.jel.tech.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:10
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor");
    }

    public void destroy() throws Exception {
        System.out.println("cat destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet");
    }
}
