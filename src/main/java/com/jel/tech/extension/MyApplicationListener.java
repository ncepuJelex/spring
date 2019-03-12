package com.jel.tech.extension;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author jelex.xu
 * @create 2019-03-12 23:41
 **/
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {


    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("receive event->" + event);
    }
}
