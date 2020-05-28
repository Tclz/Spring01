package com_5.impl;

import com_5.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public void saveAccount() {
        System.out.println("保存账户");
    }

    public void updateAccount(int i) {
        System.out.println("更新账户" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
