package com.impl;

import com.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao1")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户1");
    }
}
