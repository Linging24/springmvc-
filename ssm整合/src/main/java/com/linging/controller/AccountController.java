package com.linging.controller;

import com.linging.pojo.Account;
import com.linging.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //查询所有账户
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Account> accounts = accountService.findAllAccount();
        model.addAttribute("accounts",accounts);
        return "list";
    }

    //保存账户
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        accountService.saveAccount(account);
        return "success";
    }



}
