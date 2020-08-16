package com.linging.service.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void saveAccount(Account account) {
        accountMapper.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountMapper.deleteAccount(accountId);
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountMapper.findAccountById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountMapper.findAllAccount();
    }

    @Override
    public void transfer(String userA, String userB, float money) {
        Account a1 = accountMapper.findAccountById(1);
        Account a2 = accountMapper.findAccountById(2);

        a1.setMoney(a1.getMoney()-100);
        a2.setMoney(a2.getMoney()+100);

        accountMapper.updateAccount(a1);
        //int i = 1/0;
        accountMapper.updateAccount(a2);
    }
}
