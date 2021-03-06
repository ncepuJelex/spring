package com.jel.tech.config;

import com.jel.tech.aop.LogAspects;
import com.jel.tech.aop.MathCalculator;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序运行期间，将代码切入到指定方法位置运行
 * 导入 spring-aspects
 * MathCalculator类
 * LogAspects切面类
 *  通知方法：
 *      前置通知(@Before)：logStart,运行之前
 *      后置(@After)：logEnd,目标方法运行结束后
 *      返回(@AfterReturning)：logRet,正常返回后
 *      异常(@AfterThrowing)：logException,运行异常时
 *      环绕@Around：动态代理，手动推进方法运行，joinPoint.proceed
 *
 *  告诉spring哪个类是切面类：给切面类加个注解，@Aspect
 *  @EnableAspectJAutoProxy  非常重要
 *
 *  AOP原理：
 *      @Import(AspectJAutoProxyRegistrar.class)
        public @interface EnableAspectJAutoProxy {}
 *  org.springframework.context.annotation.AspectJAutoProxyRegistrar#registerBeanDefinitions(
 *          org.springframework.core.type.AnnotationMetadata,
 *          org.springframework.beans.factory.support.BeanDefinitionRegistry)方法中注册了
 *      AnnotationAwareAspectJAutoProxyCreator bean,它的继承关系如下:
 *          AnnotationAwareAspectJAutoProxyCreator
 *              -> AspectJAwareAdvisorAutoProxyCreator
 *                  -> AbstractAdvisorAutoProxyCreator
 *                      -> AbstractAutoProxyCreator
 *                          - - -> implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *              关注后置处理器（bean初始化前后搞了什么鬼）
 *
 *     AbstractAutoProxyCreator#setBeanFactory(..)
 *     AbstractAdvisorAutoProxyCreator#setBeanFactory(..)
 *     AnnotationAwareAspectJAutoProxyCreator#initBeanFactory(..)
 *
 *      流程：
 *          1.传递配置类，创建ioc容器；
 *          2.注册配置类，调用refresh(),刷新容器；
 *          3.registerBeanPostProcessor():
 *              先获取ioc容器中创建好的beanpostprocessor;
 *              优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *              再注册实现了Ordered接口的BeanPostProcessor
 *              最后是其它BeanPostProcessor
 *              AbstractAutowireCapableBeanFactory#initializeBean(..):初始化bean
 *              AbstractAutowireCapableBeanFactory#invokeAwareMethods(..):处理Aware接口回调
 *              AbstractAutowireCapableBeanFactory#invokeInitMethods(..)执行自定义方法
 *              AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization(..)
 *
 *  AbstractApplicationContext#finishBeanFactoryInitialization(beanFactory);
 *  AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation(..)
 *      protected Object resolveBeforeInstantiation(String beanName, RootBeanDefinition mbd) {
            Object bean = null;
            if (!Boolean.FALSE.equals(mbd.beforeInstantiationResolved)) {
            // Make sure bean class is actually resolved at this point.
            if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
            Class<?> targetType = determineTargetType(beanName, mbd);
            if (targetType != null) {
            bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
            if (bean != null) {
            bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
            }
            }
            }
            mbd.beforeInstantiationResolved = (bean != null);
            }
            return bean;
            }
 *
 *  创建bean之前调用上述代码-> aop
 *      每一个bean创建之前，调用 postBeanProcessorsBeforeInstantiation();
 *
 *
 *  AOP链：
 *      CglibAopProxy#intercept
 *          List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);

 *
 *
 * @author jelex.xu
 * @create 2019-02-27 10:37
 **/
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {

    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
