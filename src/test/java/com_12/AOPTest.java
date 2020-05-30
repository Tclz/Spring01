package com_12;
import com_12.service.IAccountService;
import com_12.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AOPTest {


    @Autowired
    private IAccountService as;


    @Test
    public void testTransfer(){
        as.transfer("ccc","bbb",100f);
    }

}
