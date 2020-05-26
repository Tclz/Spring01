package com_3.dao;

import com_3.domain.Account;

import java.util.List;

public interface IAccountDao {

    // 查询所有
    List<Account> findAllAccount();
    // 查询一个
    Account findAccountById(Integer AccountId);
    // 保存
    void saveAccount(Account account);
    // 更新
    void updateAccount(Account account);
    // 删除
    void deleteAccount(Integer accountId);
}
