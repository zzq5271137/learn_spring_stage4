package com.mycomp.spring.demo2;

/*
 * Cglib的动态代理, 不需要借口 (它使用的是继承的方式进行动态增强)
 */

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserDaoCglibProxy implements MethodInterceptor {

    public UserDao createProxy(UserDao userDao) {
        // 1. 创建一个核心类
        Enhancer enhancer = new Enhancer();

        // 2. 设置它的父类 (它使用的是继承的方式进行动态增强)
        // 这时, 它会在内部创建一个子类, 并进行增强
        enhancer.setSuperclass(userDao.getClass());

        // 3. 设置回调(增强)
        enhancer.setCallback(this);

        // 4. 创建代理对象, 就是把它上面创建的子类给你
        UserDao userDaoProxy = (UserDao) enhancer.create();

        return userDaoProxy;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        // 在这里进行判断, 只想要某些方法进行增强处理
        if ("save".equals(method.getName())) {
            // 在原有方法调用之前进行功能的添加(增强)
            check();

            // 到这里, 表示调用原有的方法
            Object proxy = methodProxy.invokeSuper(o, objects);

            // 在原有方法调用之后进行功能的添加(增强)
            log();

            return proxy;
        }

        return methodProxy.invokeSuper(o, objects);
    }

    public void check() {
        System.out.println("权限校验");
    }

    public void log() {
        System.out.println("日志信息");
    }
}
