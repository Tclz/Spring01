package com_2.service;

import com_2.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    // 查询所有
    List<Account>findAllAccount();
    // 查询一个
    Account findAccountById(Integer AccountId);
    // 保存
    void saveAccount(Account account);
    // 更新
    void updateAccount(Account account);
    // 删除
    void deleteAccount(Integer accountId);

}
