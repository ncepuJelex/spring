package com.jel.tech.config;

import com.jel.tech.dao.PersonDao;
import com.jel.tech.model.Car;
import com.jel.tech.model.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用Ioc
 *   @Autowired 自动注入
 *      默认优先按照类型去容器中找对应组件
 *      @Qualifier("personDao"):指定需要装配的id
 *    默认一定要将属性赋好值，or -> NoSuchBeanDefinitionException
 *    @Autowired 有个required 属性，默认是true
 *    @Primary 默认首选的bean,但它的优先级没有@Qualifier高
 *
 * Spring支持@Resource @Inject
 *  默认按照组件名称进行装配,它有个name属性，可以指定注入哪个bean
 *AutowiredAnnotationBeanPostProcessor 处理的
 *
 * @Inject 需要导入 javax.inject包
 *
 * @Autowired 还可以在构造器上，属性上
 *
 *
 * 自定义组件想要注入Spring底层组件，参考Aware,实现xxxAware接口
 *  查看Red类， xxxAware功能是使用xxxProcessor处理的
 *
 * @author jelex.xu
 * @create 2019-02-24 00:10
 **/
@ComponentScan({"com.jel.tech.controller","com.jel.tech.service","com.jel.tech.dao","com.jel.tech.model"})
@Configuration
public class MainConfigAutowired {

    @Primary
    @Bean("personDao2")
    public PersonDao personDao() {

        PersonDao personDao = new PersonDao();
        personDao.setId("2");
        return personDao;
    }

    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
