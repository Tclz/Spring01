package com_9.dao;

import com_8.domain.Account;

public interface IAccountDao {
    /**
     * 根据id查询账户
     */
    Account findAccountById(Integer accountId);
    /**
     * 使用名称查询
     */
    Account findAccountByName(String name);
    /**
     * 更新账户
     */
    void updateAccount(Account account);
}
