package com_1.service.impl;

import com_1.domain.Account;
import com_1.service.IAccountService;
import com_1.dao.IAccountDao;
import java.util.List;

public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层
    private  IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl() {
        super();
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer AccountId) {
        return accountDao.findAccountById(AccountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);

    }
}
