package com.impl;

import com.dao.IAccountDao;


import com.dao.IAccountDao;
import com.factory.BeanFactory;

import com.service.IAccountService;

import java.util.Date;

/*
账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;
    // 如果是经常变化的数据，并不适合用这种注入方式
    public AccountServiceImpl(String name,Integer age,Date birthday) {
        System.out.println("对象已创建");
        this.name = name;
        this.age = age;
        this.birthday = birthday;
       // System.out.println(this.name);
        //System.out.println(this.age);
        //System.out.println(this.birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void init(){
        System.out.println("对象初始化完成");
    }
    public void destroy(){
        System.out.println("对象销毁了");
    }

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }


    // 业务层实现类私有属性赋值比静态代码块快导致空指针异常
    // 解决方案 将该变量的声明放到类内部

    // Spring Ioc的思想 类把对象创建的权利交给了bean工厂，由创建对象变成申请对象
    // 降低依赖关系 削减耦合
    // 工厂制造出来的bean对象是可以复用的
    //private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    //private IAccountDao accountDao = new AccountDaoImpl();

    /**
     * 方法内与方法外的变量i
     * 验证了单例对象本身只被创建一次，但对象内部的方法会在每次调用时候重新初始化
     */

//    private int i = 1;
//    public void saveAccount(){
//        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
//        System.out.println(accountDao);
//        // 验证生成的bean对象的方法会重新初始化
//        // 多例对象没有线程安全问题
//        //int i = 1;
//        accountDao.saveAccount();
//        System.out.println(i);
//        ++i;
//    }

}
