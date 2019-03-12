package com.jel.tech.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author jelex.xu
 * @create 2019-03-12 22:49
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory invocation...");

        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount: " + beanDefinitionCount);

        String[] strings = beanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.asList(strings));
    }
}
