package com.jel.tech.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jelex.xu
 * @create 2019-02-19 23:32
 **/
public class WindowsCondition implements Condition{

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");

        return property.contains("window");
    }
}
