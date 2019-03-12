package com.jel.tech.extension;

import com.jel.tech.model.Blue;
import com.jel.tech.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author jelex.xu
 * @create 2019-03-12 22:46
 **/
@Configuration
@ComponentScan("com.jel.tech.extension")
public class ExtConfig {

    @Bean
    public Car car() {
        return new Car();
    }
}
