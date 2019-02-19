package com.jel.tech.config;

import com.jel.tech.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:01
 **/
@Configuration
@ComponentScan(value = "com.jel.tech",
//        excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,
//                              classes = {Controller.class})
//        }
        includeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION,
//            classes = Controller.class),
            @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        },useDefaultFilters = false

)
public class MyConfig {

    @Bean
    public Person person() {
        return new Person("ls", 19);
    }
}
