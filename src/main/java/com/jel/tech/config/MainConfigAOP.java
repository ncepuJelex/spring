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
