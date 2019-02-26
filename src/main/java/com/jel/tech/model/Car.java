package com.jel.tech.model;

import org.springframework.stereotype.Component;

/**
 * @author jelex.xu
 * @create 2019-02-21 22:59
 **/
@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car init...");
    }

    public void destroy() {
        System.out.println("car destroy...");
    }
}
