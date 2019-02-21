package com.jel.tech.config;

import com.jel.tech.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean生命周期：创建->初始化->销毁
 * 可以自定义初始化和销毁方法
 * 1. 指定初始化和销毁方法；init-method="" destroy-method=""
 * 2. 让Bean 实现 InitializingBean 和 DisposableBean 接口
 * @author jelex.xu
 * @create 2019-02-21 22:57
 **/
@ComponentScan("com.jel.tech.model")
@Configuration
public class MainConfigLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
