package com.linging.service.impl;

import com.linging.dao.AccountDao;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration(value = "")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier
    private AccountDao accountDao;

    public List<Account> findAll() {

        System.out.println("查询所有账户");
        return null;
    }

    public Account findOne(String name) {
        System.out.println("查询一个账户" + name);
        return null;
    }
}
