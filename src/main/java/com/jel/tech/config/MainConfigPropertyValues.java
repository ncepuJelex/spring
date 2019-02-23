package com.jel.tech.config;

import com.jel.tech.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:50
 **/
@Configuration
public class MainConfigPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
