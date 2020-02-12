package com.mycomp.spring.demo3;

/*
 * 切面类: 定义一些增强的方法
 */

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void check() {
        System.out.println("权限校验");
    }

    public void log(Object res) {
        System.out.println("日志信息: " + res);
    }

    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕前通知");

        // joingPoint及目标方法, 这里其实就是执行目标方法
        Object proceed = joinPoint.proceed();

        System.out.println("环绕后通知");

        return proceed;
    }

    public void exceptionMethod(Throwable ex) {
        System.out.println("有异常触发: " + ex.getMessage());
    }

    public void afterMethod() {
        System.out.println("最终通知执行");
    }

}
