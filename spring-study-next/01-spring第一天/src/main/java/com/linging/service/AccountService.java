package com.linging.service;

import com.linging.pojo.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findOne(String name);
}
