package com.linging.service.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import com.linging.service.AccountService;
import com.linging.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionManager transactionManager;


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

    //方法中的代码十分臃肿，采用动态代理抽取公共代码
    /*public void transfer(String userA, String userB, float money) {
        //出异常，导致数据库数据不一致，因为每个方法调用都会创建一个连接，每个连接都有独立的事务
        //解决：使用ThreadLocal对象把connection和当前线程绑定，从而使一个线程只能有一个控制事务的对象(connection)

        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account1 = accountMapper.findAccountByName(userA);
            Account account2 = accountMapper.findAccountByName(userB);

            account1.setMoney(account1.getMoney()-money);
            account2.setMoney(account2.getMoney()+money);

            accountMapper.update(account1);
            //int i = 1/0;
            accountMapper.update(account2);

            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            e.printStackTrace();
            //4.回滚事务
            transactionManager.rollback();
        }finally {
            //5.释放资源
            transactionManager.close();
        }
    }*/

    //方法中的代码十分臃肿，采用动态代理抽取公共代码
    public void transfer(String userA, String userB, float money) {
        //出异常，导致数据库数据不一致，因为每个方法调用都会创建一个连接，每个连接都有独立的事务
        //解决：使用ThreadLocal对象把connection和当前线程绑定，从而使一个线程只能有一个控制事务的对象(connection)

        Account account1 = accountMapper.findAccountByName(userA);
        Account account2 = accountMapper.findAccountByName(userB);

        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);

        accountMapper.update(account1);
        //int i = 1/0;
        accountMapper.update(account2);
    }
}
