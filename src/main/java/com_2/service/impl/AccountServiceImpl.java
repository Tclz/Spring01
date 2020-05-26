package com_2.service.impl;

import com_2.dao.IAccountDao;
import com_2.domain.Account;
import com_2.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层
    @Autowired
    private  IAccountDao accountDao;

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
