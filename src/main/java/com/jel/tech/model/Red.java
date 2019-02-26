package com.jel.tech.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author jelex.xu
 * @create 2019-02-19 23:47
 **/
@Component
public class Red implements ApplicationContextAware, BeanNameAware,
        EmbeddedValueResolverAware {

    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("ioc:{}" + applicationContext);

        this.context = applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println("bean name:{}" + name);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        String s = resolver.resolveStringValue("您好${os.name},my No. is #{18+1}");
        System.out.println(s);
    }
}
