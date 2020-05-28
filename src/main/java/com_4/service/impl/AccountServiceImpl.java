package com_4.service.impl;

import com_4.dao.IAccountDao;
import com_4.domain.Account;
import com_4.service.IAccountService;
import com_4.utils.TransactionManager;

import java.util.List;

/**
 * 事务的控制应该在业务层
 */

public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层
    private  IAccountDao accountDao;
    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountServiceImpl() {
        super();
    }

    public List<Account> findAllAccount() {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account>accounts =  accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;

        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        }finally {
            // 6.释放连接
            txManager.release();
        }

    }

    public Account findAccountById(Integer AccountId) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account =  accountDao.findAccountById(AccountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;

        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        }finally {
            // 6.释放连接
            txManager.release();

        }

    }

    public void saveAccount(Account account) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果

        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        }finally {
            // 6.释放连接
            txManager.release();

        }


    }

    public void updateAccount(Account account) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果


        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        }finally {
            // 6.释放连接
            txManager.release();

        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果


        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);

        }finally {
            // 6.释放连接
            txManager.release();

        }

    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            //2.执行操作

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
            //2.6更新转入账户
            accountDao.updateAccount(target);


            //3提交事务
            txManager.commit();

            //4.返回结果


        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            e.printStackTrace();

        }finally {
            // 6.释放连接
            txManager.release();

        }


    }
}
