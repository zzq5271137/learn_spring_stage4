package com.mycomp.spring.demo1;

public class GoodsDaoImpl implements IGoodsDao {

    @Override
    public void save() {
        System.out.println("goodsDao 保存操作...");
    }

    @Override
    public void update() {
        System.out.println("goodsDao 更新操作...");
    }

}
