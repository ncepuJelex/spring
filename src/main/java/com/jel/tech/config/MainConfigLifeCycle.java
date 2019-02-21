package com.jel.tech.config;

import com.jel.tech.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean生命周期：创建->初始化->销毁
 * 可以自定义初始化和销毁方法
 * 1. 指定初始化和销毁方法；init-method="" destroy-method=""
 * 2. 让Bean 实现 InitializingBean 和 DisposableBean 接口
 * 3. PostConstruct 注解：bean创建完成，属性赋值完成，执行初始化， JSR250，
 *    PreDestroy 注解：bean移除之前调用；
 * 4. BeanPostProcessor 接口：
 *      postProcessBeforeInitialization(); 初始化工作之前
 *      postProcessAfterInitialization(); 初始化之后
 *      遍历容器中得到的BeanPostProcessor，执行beforeInitialization(),
 *      一旦返回null, 跳出循环，不会执行后面的BeanPostProcessor
 *
 *      源码：
 *          // Initialize the bean instance.
         Object exposedObject = bean;
         try {
         populateBean(beanName, mbd, instanceWrapper);  // 赋值
         if (exposedObject != null) {
         exposedObject = initializeBean(beanName, exposedObject, mbd); // BeanPostProcessor处理
         }
         }
         catch (Throwable ex) {
         if (ex instanceof BeanCreationException && beanName.equals(((BeanCreationException) ex).getBeanName())) {
         throw (BeanCreationException) ex;
         }
         else {
         throw new BeanCreationException(
         mbd.getResourceDescription(), beanName, "Initialization of bean failed", ex);
         }
         }
        。。。

         Object wrappedBean = bean;
         if (mbd == null || !mbd.isSynthetic()) {
         wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
         }

         try {
         invokeInitMethods(beanName, wrappedBean, mbd); // BeanPostProcessor处理之后执行初始化方法
         }
 * @author jelex.xu
 * @create 2019-02-21 22:57
 **/
@ComponentScan("com.jel.tech.model")
@Configuration
public class MainConfigLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
