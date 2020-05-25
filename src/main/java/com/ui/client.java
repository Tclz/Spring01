package com.ui;
import com.dao.IAccountDao;
import com.impl.AccountServiceImpl;
import com.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.cert.X509Certificate;
import com.impl.AccountServiceImpl;
import com.service.IAccountService;

/*
由于没有浏览器存在，这里模拟一个表现层,用于调用业务层
 */

public class client {
    /**
     * 获取spring核心容器，并根据id获取对象
     *
     * ApplicationContext 接口的三种常用实现方式：
     *      ClassPathXmlApplicationContext:
     *          可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载失败 (更常用一些)
     *      FileSystemXmlApplicationContext:
     *          可以加载任意磁盘路径下的配置文件(必须要有访问权限)
     *      AnnotationConfigApplicationContext:
     *          用于读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题：
     * ApplicationContext:  (单例对象适用)
     *      在构建核心容器时，创建对象采取的策略是采用立即加载的方式。即一读取完配置文件就马上创建配置文件中的对象
     * BeanFactory:      (多例对象适用)
     *      它在创建核心容器时，创建对象采用的策略是延迟的加载的方式，也即什么时候根据id获取对象了，什么时候才真正创建对象
     *
     * @param args
     */
    public static void main(String[] args) {

//        // 1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        // 2.根据id获取bean对象
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountDao ad = (IAccountDao)ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(ad);
//        as.saveAccount();

        // BeanFactory方式
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        bdr.loadBeanDefinitions(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        System.out.println(as);
/**
 *  每次按同样的名称取bean对象，默认获得一个重新创建的bean对象
 *  多例：
 *      对象会被创建多次，执行效率没有单例对象高
 *  单例：
 *      对象只被创建一次，从而类中成员也就只被初始化一次
 */
//public class client {
//    public static void main(String[] args) {
//        //IAccountService as = new AccountServiceImpl();
//        // service的单例/多例测试
//        for(int i=0;i<5;++i){
//            IAccountService as = (IAccountService)BeanFactory.getBean("accountService");
//            System.out.println(as);
//            as.saveAccount();
//
//        }
//
//
//    }
    }
}
