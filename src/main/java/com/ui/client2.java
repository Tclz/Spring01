package com.ui;
import com.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
由于没有浏览器存在，这里模拟一个表现层,用于调用业务层
 */

public class client2 {

    public static void main(String[] args) {

        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        IAccountService as = (IAccountService)ac.getBean("accountServiceImpl4");
        as.saveAccount();

    }
}
