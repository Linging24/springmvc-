package com.linging.component;

import com.linging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class MoreAccountService {

    @Autowired
    private AccountService accountService;


    public void testAccountService(){
        System.out.println(accountService);
    }
}
