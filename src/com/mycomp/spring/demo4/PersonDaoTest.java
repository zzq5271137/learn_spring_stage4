package com.mycomp.spring.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonDaoTest {

    @Resource(name = "personDao")
    private IPersonDao personDao;

    @Test
    public void test() {
        this.personDao.save();
        System.out.println("===================");
        this.personDao.update();
        System.out.println("===================");
        this.personDao.find();
    }

}
