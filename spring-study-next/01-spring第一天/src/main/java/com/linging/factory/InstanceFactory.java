package com.linging.factory;

import com.linging.service.AccountService;
import com.linging.service.impl.AccountServiceImpl;

//实例工厂
public class InstanceFactory {

    public AccountService createAccountServiceByInstance(){
        return new AccountServiceImpl();
    }
}
