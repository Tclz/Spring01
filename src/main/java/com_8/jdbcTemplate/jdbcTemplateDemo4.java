package com_8.jdbcTemplate;

import com_8.dao.IAccountDao;
import com_8.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateDemo4 {
    public static void main(String[] args) {
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean_jdbc.xml");
        // 获取对象
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);

        Account account = accountDao.findAccountById(5);
        System.out.println(account);

        account.setName("qqqq");
        accountDao.updateAccount(account);


    }
}
