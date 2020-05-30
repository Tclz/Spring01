package com_10.dao.impl;

import com_10.dao.IAccountDao;
import com_10.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accountList = super.getJdbcTemplate().query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accountList.isEmpty()?null:accountList.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account>accountList = super.getJdbcTemplate().query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accountList.isEmpty()){
            return  null;
        }
        if(accountList.size()>1)
        {
            throw new RuntimeException("结果集不唯一");
        }
        return accountList.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ? , money = ?where id = ?",account.getName(),account.getMoney(),account.getId());

    }
}
