package com.linging.test;

import com.linging.component.MoreAccountService;
import com.linging.config.SpringBeanConfg;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {

    ApplicationContext context = null;
    AccountService accountService = null;

    //@Before
    public void init(){
        context = new AnnotationConfigApplicationContext(SpringBeanConfg.class);
        accountService = context.getBean("accountService", AccountService.class);
    }

    /**
     * 测试查询全部账户
     */
    @Test
    public void testFindAll(){
        System.out.println(accountService.findAllAccount());
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindOne(){
        System.out.println(accountService.findAccountById(1));
    }

    /**
     * 测试插入
     */
    @Test
    public void testInsert(){
        Account account = new Account();
        account.setName("张三");
        account.setMoney(8888f);
        accountService.saveAccount(account);
    }

    /**
     * 跟新账户
     */
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setName("张三1111");
        account.setMoney(9999f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(4);
    }


    @Test
    public void testMoreAccountService(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfg.class);
        MoreAccountService moreAccountService = context.getBean(MoreAccountService.class);
        moreAccountService.testAccountService();
    }

}
