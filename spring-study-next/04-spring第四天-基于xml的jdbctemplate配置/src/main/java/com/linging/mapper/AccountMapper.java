package com.linging.mapper;

import com.linging.pojo.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountMapper {

    /**
     * 保存
     * @param account
     */
    void save(Account account);
    /**
     * 更新
     * @param account
     */
    void update(Account account);
    /**
     * 删除
     * @param accountId
     */
    void delete(Integer accountId);
    /**
     * 根据 id 查询
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 根据账户名查找账户
     * @return
     */
    Account findAccountByName(String name);

}
