package com.impl;

import com.dao.IAccountDao;
import com.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.birthday);
    }
}
