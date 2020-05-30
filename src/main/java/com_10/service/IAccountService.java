package com_10.service;

import com_10.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     */
    Account findAccountById(Integer id);
    void transfer(String SourceName,String targetName,float money);

}
