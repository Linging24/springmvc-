package com.linging.test;

import com.linging.config.SpringBeanConfg;
import com.linging.service.AccountService;
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

    @Test
    public void test(){
        accountService.transfer("aaa","bbb",100f);;
    }


}
