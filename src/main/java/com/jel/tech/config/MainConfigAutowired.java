package com.jel.tech.config;

import com.jel.tech.dao.PersonDao;
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
 * @author jelex.xu
 * @create 2019-02-24 00:10
 **/
@ComponentScan({"com.jel.tech.controller","com.jel.tech.service","com.jel.tech.dao"})
@Configuration
public class MainConfigAutowired {

    @Primary
    @Bean("personDao2")
    public PersonDao personDao() {

        PersonDao personDao = new PersonDao();
        personDao.setId("2");
        return personDao;
    }
}
