package com.jel.tech.config;

import com.jel.tech.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:50
 **/
// 读取外围配置文件中的k/v保存到运行的环境变量中
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
