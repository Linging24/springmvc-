package com.linging.factory;

import com.linging.service.AccountService;
import com.linging.service.impl.AccountServiceImpl;

//静态工厂
public class StaticFactory {

    public static AccountService createAccountServiceByStatic(){
        return new AccountServiceImpl();
    }
}
