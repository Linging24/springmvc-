package com.linging.test;
import com.linging.pojo.Account;
import com.linging.pojo.DIAccount;
import com.linging.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    /**
     * 测试spring创建对象的三种方式
     */
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService =  ac.getBean("accountService",AccountService.class);
        AccountService accountService2 =  ac.getBean("accountService",AccountService.class);
        AccountService staticAccountService = ac.getBean("staticAccountService", AccountService.class);
        AccountService instanceAccountService = ac.getBean("instanceAccountService", AccountService.class);
        System.out.println(accountService == accountService2);  //默认单例模式
        System.out.println(staticAccountService);
        System.out.println(instanceAccountService);

    }


    /**
     * 依赖注入
     */
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        DIAccount diAccount = ac.getBean("diAccount", DIAccount.class);
        DIAccount diAccount2 = ac.getBean("diAccount2", DIAccount.class);
        System.out.println(diAccount);
        System.out.println(diAccount2);

        DIAccount diAccount3 = ac.getBean("diAccount3", DIAccount.class);
        System.out.println(diAccount3);
    }


}
