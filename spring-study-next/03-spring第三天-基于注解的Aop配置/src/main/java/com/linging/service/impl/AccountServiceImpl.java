package com.linging.service.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import com.linging.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public void transfer(String userA, String userB, float money) {
        //出异常，导致数据库数据不一致，因为每个方法调用都会创建一个连接，每个连接都有独立的事务
        //解决：使用ThreadLocal对象把connection和当前线程绑定，从而使一个线程只能有一个控制事务的对象(connection)

        Account account1 = accountMapper.findAccountByName(userA);
        Account account2 = accountMapper.findAccountByName(userB);

        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);

        accountMapper.update(account1);
        int i = 1/0;
        accountMapper.update(account2);
    }
}
