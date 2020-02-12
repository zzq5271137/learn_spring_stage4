package com.mycomp.spring.demo2;

import org.junit.Test;

public class UserDaoTest {

    @Test
    public void test() {
        UserDao userDao = new UserDao();

        UserDaoCglibProxy userDaoCglibProxy = new UserDaoCglibProxy();
        UserDao userDaoProxy = userDaoCglibProxy.createProxy(userDao);
        userDaoProxy.save();
        System.out.println("====================");
        userDaoProxy.update();
    }

}
