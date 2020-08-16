package com.linging.dao;

import com.linging.pojo.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findOne(String name);


}
