package com.mycomp.spring.demo4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
 * 以注解的形式配置AOP
 */

@Aspect
public class PersonDaoAspect {

    // 前置通知
    @Before(value = "PersonDaoAspect.updatePointcut() || PersonDaoAspect.savePointcut()")
    public void check() {
        System.out.println("权限检查");
    }

    // 后置通知
    @AfterReturning(value = "PersonDaoAspect.updatePointcut()", returning = "res")
    public void log(Object res) {
        System.out.println("日志信息: " + res);
    }

    // 环绕通知
    @Around(value = "PersonDaoAspect.updatePointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后通知");
        return proceed;
    }

    // 异常通知
    @AfterThrowing(value = "PersonDaoAspect.findPointcut()", throwing = "ex")
    public void exceptionMethod(Throwable ex) {
        System.out.println("有异常触发: " + ex.getMessage());
    }

    // 最终通知
    @After(value = "PersonDaoAspect.allPointcut()")
    public void afterMethod() {
        System.out.println("最终通知执行");
    }

    /*
     * 注解简写形式
     */
    @Pointcut(value = "execution(* com.mycomp.spring.demo4.PersonDaoImpl.*(..))")
    private void allPointcut() {
    }

    @Pointcut(value = "execution(* com.mycomp.spring.demo4.PersonDaoImpl.update(..))")
    private void updatePointcut() {
    }

    @Pointcut(value = "execution(* com.mycomp.spring.demo4.PersonDaoImpl.save(..))")
    private void savePointcut() {
    }

    @Pointcut(value = "execution(* com.mycomp.spring.demo4.PersonDaoImpl.find(..))")
    private void findPointcut() {
    }
}
