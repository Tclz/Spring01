package com_9.service;

import com_8.domain.Account;

public interface IAccountService {
    /**
     * 根据id查询账户
     */
    com_8.domain.Account findAccountById(Integer accountId);
    /**
     * 使用名称查询
     */
    com_8.domain.Account findAccountByName(String name);
    /**
     * 更新账户
     */
    void updateAccount(Account account);

}
