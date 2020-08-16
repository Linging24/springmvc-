package com.linging.controller;


import com.linging.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    /**
     * 接受前端的json字符串，由springMVC帮我们转为对象
     * 并响应json串给前端
     * @param account
     * @return
     */
    @RequestMapping(value = "/testAjax",method = RequestMethod.POST)
    public @ResponseBody Account ajax(@RequestBody Account account){
        System.out.println(account);
        account.setName("李四");
        account.setMoney(2000);
        //返回对象，springMvc将javaBean转为json串，传递给前端
        return account;
    }
}
