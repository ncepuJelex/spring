package com.jel.tech.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jelex.xu
 * @create 2019-02-19 23:32
 **/
public class LinuxCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        BeanDefinitionRegistry registry = context.getRegistry();
        boolean personContains = registry.containsBeanDefinition("person");
        System.out.println(personContains);

        Environment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");
        if (property.contains("window")) {
            return false;
        }
        return true;
    }
}
