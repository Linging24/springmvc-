package com.linging.service.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import com.linging.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

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
