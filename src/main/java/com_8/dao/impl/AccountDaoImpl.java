package com_8.dao.impl;

import com_8.dao.IAccountDao;
import com_8.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accountList.isEmpty()?null:accountList.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account>accountList = jdbcTemplate.query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accountList.isEmpty()){
            return  null;
        }
        if(accountList.size()>1)
        {
            throw new RuntimeException("结果集不唯一");
        }
        return accountList.get(0);
    }

}
