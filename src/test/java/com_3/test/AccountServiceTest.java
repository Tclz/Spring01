package com_3.test;

import com_3.config.SpringConfiguration;
import com_3.domain.Account;
import com_3.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试
 *
 * 扩展知识：
 *      1. 应用程序入口
 *          main方法
 *      2. junit单元测试中，没有main方法也能执行
 *         junit集成了一个main方法，该方法会判断当前测试类中哪些方法有@Test注解，junit就让有Test注解的方法执行
 *      3. junit不会管我们是否采用spring框架
 *          在执行测试方法时，junit根本不知道是否使用了spring框架
 *          所以也就不会去读取配置文件/配置类为我们创建spring核心容器
 *      4.  由以上三点可知：当测试方法执行时，没有ioc容器，就算写了AutoWired注解，也无法实现注入
 *
 * 解决方案：
 *  Spring整合junit的配置
 *      1. 导入spring整合junit的jar包（或者叫坐标）
 *      2. 使用junit提供的一个注解把原有的main方法进行替换，替换成spring提供的@Runwith
 *      3. 告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration:
 *              locations: 指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes: 指定注解类所在位置
 *  当使用Spring 5.x 版本时，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as = null;

    @Test
    public void testFindAll(){

        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        Account account = as.findAccountById(1);
        System.out.println(account);

    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setId(4);
        account.setName("Mary");
        account.setMoney(600);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        Account account = as.findAccountById(3);
        account.setMoney(2345);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(1);

    }
}
