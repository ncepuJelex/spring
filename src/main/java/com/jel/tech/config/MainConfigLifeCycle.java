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
 * 3. PostConstruct 注解：bean创建完成，属性赋值完成，执行初始化， JSR250，
 *    PreDestroy 注解：bean移除之前调用；
 * 4. BeanPostProcessor 接口：
 *      postProcessBeforeInitialization(); 初始化工作之前
 *      postProcessAfterInitialiazation(); 初始化之后
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
