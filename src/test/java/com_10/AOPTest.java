package com_10;
import com_10.domain.Account;
import com_10.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean_10.xml")
public class AOPTest {


    @Autowired
    private IAccountService as;


    @Test
    public void testTransfer(){
        as.transfer("ccc","bbb",100f);
    }

}
