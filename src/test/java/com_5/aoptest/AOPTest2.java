package com_5.aoptest;

import com_6.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 */
public class AOPTest2 {
    public static void main(String[] args) {
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean_aop_2.xml");
        // 2.获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 3.执行方法
        as.saveAccount();

    }
}
