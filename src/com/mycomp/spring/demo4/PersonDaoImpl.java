package com.mycomp.spring.demo4;

public class PersonDaoImpl implements IPersonDao {

    @Override
    public void save() {
        System.out.println("personDao 保存操作...");
    }

    @Override
    public String update() {
        System.out.println("personDao 更新操作...");
        return "personDao 更新完成";
    }

    @Override
    public void find() {
        System.out.println("personDao 查找操作...");
        int num = 1 / 0;
    }
}
