package com.jel.tech.config;

import com.jel.tech.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:01
 **/
@Configuration
@ComponentScan(value = "com.jel.tech")
public class MyConfig2 {

    /**
     * 多实例时，ioc容器启动不会去创建对象，而单实例会！
     * @return
     */
    /**
     * 懒加载：
     *  单实例时，默认在容器创建后会创建对象
     * @return
     */
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public Person person() {
        System.out.println("person init");
        return new Person("ls", 19);
    }
}
