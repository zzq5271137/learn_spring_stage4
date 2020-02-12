package com.mycomp.spring.demo3;

public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public void save() {
        System.out.println("customerDao 保存操作...");
    }

    @Override
    public String update() {
        System.out.println("customerDao 更新操作...");
        return "customerDao 更新完成";
    }

    @Override
    public void delete() {
        System.out.println("customerDao 删除操作...");
    }

    @Override
    public void find() {
        System.out.println("customerDao 查找操作...");

        // 触发异常
        int num = 1 / 0;
    }
}
