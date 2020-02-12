package com.mycomp.spring.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {

    @Resource(name = "customerDao")
    private ICustomerDao customerDao;

    @Test
    public void test() {
        this.customerDao.save();
        System.out.println("====================");
        this.customerDao.update();
        System.out.println("====================");
        this.customerDao.delete();
        System.out.println("====================");
        this.customerDao.find();
    }

}
