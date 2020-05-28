package com_4.test;
import com_4.domain.Account;
import com_4.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean6.xml")
public class AccountServiceTest_new {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as = null;

    @Test
    public void testFindAll(){

        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){
        as.transfer("bbb","ccc",100f);
    }

}
