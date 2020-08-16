package com.linging.test;

import com.linging.config.SpringBeanConfg;
import com.linging.动态代理.CglibProxy;
import com.linging.动态代理.JDKProxy;
import com.linging.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBeanConfg.class)
public class ProxyTest {

    @Autowired
    private JDKProxy jdkProxy;

    @Autowired
    private CglibProxy cglibProxy;

    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        //拿到AccountService的代理对象
        AccountService proxyAccountService = (AccountService) jdkProxy.getProxy(accountService);
        System.out.println(proxyAccountService.findAllAccount());
    }


    @Test
    public void testCglib(){
        AccountService proxyAccountService = (AccountService) cglibProxy.getProxy(accountService);
        System.out.println(proxyAccountService.findAllAccount());
    }
}
