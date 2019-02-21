package com.jel.tech;

import com.jel.tech.config.MainConfigLifeCycle;
import com.jel.tech.model.Car;
import org.junit.Test;
import org.springframework.cache.annotation.AnnotationCacheOperationSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jelex.xu
 * @create 2019-02-21 23:01
 **/
public class LifeCycleTest {

    @Test
    public void fun1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        System.out.println("container init ok.");
        /**
         * running result:
         *  car constructor...
         car init...
         container init ok.
         */
        context.destroy();
        //console-> car destroy...

        /**
         * prototype范围时：内容负责创建，但不管理
         */
//        context.getBean(Car.class);

        /**
         * InitializingBean和DisposableBean
         * cat constructor
         cat afterPropertiesSet
         car constructor...
         car init...

         container init ok.
         car destroy...
         cat destroy
         */

        /**
         * @PreDestroy @PostConstruct
         * cat constructor
         cat afterPropertiesSet
         dog constructor
         dog postConstruct
         car constructor...
         car init...
         container init ok.
         car destroy...
         dog preDestroy
         cat destroy
         */
    }
}
