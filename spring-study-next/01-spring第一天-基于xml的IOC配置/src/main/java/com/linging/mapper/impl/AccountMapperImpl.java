package com.linging.mapper.impl;

import com.linging.mapper.AccountMapper;
import com.linging.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountMapperImpl implements AccountMapper {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Account account) {
        jdbcTemplate.update("insert into account(id,name,money) values(?,?,?)",account.getId(),account.getName(),account.getMoney());
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    public void delete(Integer accountId) {
        jdbcTemplate.update("delete from account where id = ?",accountId);
    }

    public Account findById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select *from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        if(accounts.isEmpty()) return null;
        if(accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public List<Account> findAll() {
        List<Account> accounts = jdbcTemplate.query("select *from account", new BeanPropertyRowMapper<Account>(Account.class), null);
        return accounts.isEmpty() ? null : accounts;
    }
}
