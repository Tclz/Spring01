package com_11.service.impl;

import com_11.dao.IAccountDao;
import com_11.domain.Account;
import com_11.service.IAccountService;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 事务的控制应该在业务层
 *
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型事务配置
public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层
    @Autowired
    private  IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Account findAccountById(Integer AccountId) {
            return accountDao.findAccountById(AccountId);

    }

    // 读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, float money) {

            // 2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            // 2.5更新转出账户
            accountDao.updateAccount(source);
            // 测试动态代理是否正常工作
            //int i = 1/0;
            accountDao.updateAccount(target);
    }
}
