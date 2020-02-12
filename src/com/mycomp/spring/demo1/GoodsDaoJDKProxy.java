package com.mycomp.spring.demo1;

/*
 * JDK的动态代理, 要求必须有接口
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GoodsDaoJDKProxy {

    public IGoodsDao creatProxy(IGoodsDao goodsDao) {
        // 增强
        IGoodsDao goodsDapProxy = (IGoodsDao) Proxy.newProxyInstance(goodsDao.getClass().getClassLoader(),
                goodsDao.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 当调用代理对象的方法的时候, 里面所有的方法都会来到这里
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 在这里进行判断, 只想要某些方法进行增强处理
                        if ("save".equals(method.getName())) {
                            System.out.println("调用代理对象增强方法...");

                            // 在原有方法调用之前进行功能的添加(增强)
                            check();

                            // 到这里, 表示调用goodsDao原有的方法, 会返回一个代理对象
                            proxy = method.invoke(goodsDao, args);

                            // 在原有方法调用之后进行功能的添加(增强)
                            log();

                            return proxy;
                        }

                        return method.invoke(goodsDao, args);
                    }

                    public void check() {
                        System.out.println("权限校验");
                    }

                    public void log() {
                        System.out.println("日志信息");
                    }
                });
        return goodsDapProxy;
    }

}
