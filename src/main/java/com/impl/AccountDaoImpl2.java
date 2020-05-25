package com.impl;

import com.dao.IAccountDao;
import org.springframework.stereotype.Repository;

//  与要注入的变量类型相同的bean有多个，AutoWired不工作
@Repository(value = "accountDao2")

public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户2");
    }
}
