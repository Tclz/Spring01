package com_3.test;

import com_3.config.SpringConfiguration;
import com_3.domain.Account;
import com_3.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        /**
         * 通过SpringConfiguration配置类而非bean.xml的方式获取容器
         */
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }
    @Test
    public void testSave(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 3.执行方法
        Account account = new Account();
        account.setId(4);
        account.setName("Mary");
        account.setMoney(600);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 3.执行方法
        Account account = as.findAccountById(3);
        account.setMoney(2345);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 3.执行方法
        as.deleteAccount(1);

    }
}
