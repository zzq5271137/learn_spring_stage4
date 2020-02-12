package com.mycomp.spring.demo1;

import org.junit.Test;

public class GoodsDaoTest {

    @Test
    public void test() {
        IGoodsDao goodsDao = new GoodsDaoImpl();
        // goodsDao.save();

        GoodsDaoJDKProxy goodsDaoJDKProxy = new GoodsDaoJDKProxy();
        // 获取的代理对象
        IGoodsDao goodsDaoProxy = goodsDaoJDKProxy.creatProxy(goodsDao);
        goodsDaoProxy.save();
        System.out.println("====================");
        goodsDaoProxy.update();
    }

}
