package com.jel.tech.condition;

import com.jel.tech.model.Yellow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jelex.xu
 * @create 2019-02-19 23:57
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 把需要注册的bean添加到容器中
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.jel.tech.model.Red");
        boolean blue = registry.containsBeanDefinition("com.jel.tech.model.Blue");
        if (red && blue) {
            BeanDefinition beanDefinition = new RootBeanDefinition(Yellow.class);
            registry.registerBeanDefinition("yellow", beanDefinition);
        }
    }
}
