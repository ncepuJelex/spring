package com.jel.tech.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:18
 **/
@Component
public class Dog implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    public Dog() {
        System.out.println("dog constructor");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("dog postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("dog preDestroy");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
