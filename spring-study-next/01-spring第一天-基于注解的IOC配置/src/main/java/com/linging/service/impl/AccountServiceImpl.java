package com.linging.service.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("accountService")
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void saveAccount(Account account) {
        accountMapper.save(account);
    }

    public void updateAccount(Account account) {
        accountMapper.update(account);
    }

    public void deleteAccount(Integer accountId) {
        accountMapper.delete(accountId);
    }

    public Account findAccountById(Integer accountId) {
        return accountMapper.findById(accountId);
    }

    public List<Account> findAllAccount() {
        return accountMapper.findAll();
    }
}
