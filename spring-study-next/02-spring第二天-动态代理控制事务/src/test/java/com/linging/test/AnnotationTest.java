package com.linging.test;

import com.linging.config.SpringBeanConfg;
import com.linging.service.AccountService;
import com.linging.动态代理.JDKProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //替换junit的默认运行器
@ContextConfiguration(classes = SpringBeanConfg.class)  //指定spring配置类或配置文件的位置
//@ContextConfiguration(locations = "classpath:bean.xml")
public class AnnotationTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxy jdkProxy;

    //没有使用动态代理
    @Test
    public void test(){
        accountService.transfer("aaa","bbb",100f);
    }

    //使用动态代理
    @Test
    public void test2(){
        AccountService proxyAccountServiceTx = (AccountService) jdkProxy.getProxyTx(accountService);
        proxyAccountServiceTx.transfer("aaa","bbb",100f);
    }




}
