package com.jel.tech.config;

import com.jel.tech.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:01
 **/
@Configuration
public class MyConfig {

    @Bean
    public Person person() {
        return new Person("ls", 19);
    }
}
