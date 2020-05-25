package com.impl;

import com.dao.IAccountDao;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务实现类：
 *      曾经的XML的配置：
 *           <bean id="accountService" class="com.impl.AccountServiceImpl"></bean>
 *
 * 接下来是基于注解的Ioc：
 * 4类注解：
 * 1. 用于创建对象
 *      作用和在XML配置文件中编写的<bean></bean>标签实现的功能是一样的
 *      Component
 *          作用：用于把当前对象存入spring容器中
 *          属性：
 *              value： 用于指定bean的id。不写时默认值是当前类名，且首字母小写
 *      Controller: 一般用在表现层
 *      Service:    一般用在业务层
 *      Repository: 一般用在持久层
 *
 * 2.用于注入数据
 *      作用和XML中编写的<property></property>标签一样
 *      Autowired:
 *              作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，
 *                    如果ioc容器中没有任何的bean类型和要注入的变量类型匹配 则报错；
 *                    若与变量类型匹配的bean对象有多个，spring将把变量名作为bean的id再做一次仔细匹配
 *              出现位置：可以是变量上，也可以是方法上
 *              一个细节：
 *                      使用注解注入时，set方法不是必须的
 *      Qualifier:
 *          作用：在按照类型注入的基础上再按照名称注入。它在给类成员注入时不能单独使用，但是在给方法注入时可以
 *          属性：
 *              value:用于指定注入bean的id
 *      Resource:
 *          作用：直接按照bean的id注入。可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *      ==================================================
 *      以上三个注解都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过XML来实现。
 *
 *      Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中SpEL(也就是spring中的el表达式)
 *                      SpEL写法：${表达式}
 * 3.用于改变作用范围
 *      与XML中使用的scope属性功能一样
 *      Scope:
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton、prototype  （默认是单例的）
 *
 * 4.和生命周期相关
 *      与XML中init-method和destroy-method的作用一样
 *      PreDestroy:
 *          作用：用于指定销毁方法
 *      PostConstruct:
 *          作用：用于指定初始化方法
 *
 */

@Service(value = "accountService")
public class AccountServiceImpl4 implements IAccountService {

    /**
    @Autowired
    // 如果有多个同类型的bean 那么再由Qualifier注解进一步指定用哪个
    @Qualifier("accountDao2")
    */
    // 或者直接用Resource注解一步到位
    @Resource(name = "accountDao1")
    private IAccountDao accountDao = null;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行");
    }
    public void saveAccount(){
        accountDao.saveAccount();
    }

}
