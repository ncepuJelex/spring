package com.jel.tech.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author jelex.xu
 * @create 2019-02-27 10:41
 **/
@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    @Pointcut("execution(public int com.jel.tech.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("execution(public int com.jel.tech.aop.MathCalculator.*(..))")
    public void logStart(JoinPoint joinPoint) {

        System.out.println("div start...,args-> {}" + joinPoint.getSignature().getName() + ",," + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
//    @After("com.jel.tech.aop.pointCut()")
    public void logEnd() {

        System.out.println("div ends...");
    }

    @AfterReturning(value="pointCut()", returning = "result")
    public void logRet(Object result) {

        System.out.println("div return...,result-> {}" + result);
    }

    // JoinPoint必须是第一个参数
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {

        System.out.println("div exception,-> {}");
        ex.printStackTrace();
    }


    public void fun() {

    }
}
