package com.jel.tech.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jelex.xu
 * @create 2019-02-26 23:37
 **/
// 默认加上Ioc容器的组件，会调用无参构造，初始化
@Component
public class Boss {

    private Car car;

    // 如果只有一个有参构造器，则它的@Autowired 可以省略
//    @Autowired
    public Boss(/*@Autowired*/ Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    // 标注在方法上，方法使用的参数、自定义odgar值
    // 从容器中获取
//    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
}
