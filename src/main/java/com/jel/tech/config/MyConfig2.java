package com.jel.tech.config;

import com.jel.tech.condition.LinuxCondition;
import com.jel.tech.condition.WindowsCondition;
import com.jel.tech.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:01
 **/
@Configuration
@ComponentScan(value = "com.jel.tech")
//@Conditional({WindowsCondition.class})
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

    /**
     * @Conditional
     */
    /**
     * 如果电脑系统 是windows,给容器注册bill,否则注册linus
     * @return
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("bill gates", 64);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("Linus", 50);
    }
}
