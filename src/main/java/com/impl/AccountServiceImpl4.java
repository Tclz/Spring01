package com.impl;

import com.dao.IAccountDao;
import com.service.IAccountService;
import org.springframework.stereotype.Component;

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
 * 2.用于注入数据
 *      作用和XML中编写的<property></property>标签一样
 * 3.用于改变作用范围
 *      与XML中使用的scope属性功能一样
 * 4.和生命周期相关
 *      与XML中init-method和destroy-method的作用一样
 *
 */
@Component
public class AccountServiceImpl4 implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public void saveAccount(){
        accountDao.saveAccount();
    }

}
