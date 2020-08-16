package com.linging.controller;

import com.linging.pojo.Account;
import com.linging.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/hello")
@SessionAttributes(value = {"name","age"}, types = {String.class,Integer.class})
public class HelloController {

    //入门案例
    @RequestMapping("/mvc")
    public String hello(){
        return "success";
    }


    //get请求参数接收
    @RequestMapping("/getParam")
    public String getParam(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    //post请求参数的接收
    @RequestMapping("/postParam")
    public String postParam(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    //实体类接收参数
    @RequestMapping("/entityParam")
    public String entityParam(User user){
        System.out.println(user);
        return "success";
    }

    //获取请求体的内容
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    //用于绑定url中的占位符
    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable("uid") String id){
        System.out.println(id);
        return "success";
    }


    //获取指定请求头的值
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String accept){
        System.out.println(accept);
        return "success";
    }

    //获取指定cookie名称的值
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "success";
    }

    //ModelAttribute用在类上,先于控制器的方法执行，带返回值,
    @ModelAttribute
    public Account preController(String name){
        //模拟查询数据库,用户提交的数据只有少部分，查询数据库将空的字段填充上去
        Account account = new Account();
        account.setId(1);
        account.setMoney(1000f);
        return account;
    }
    //测试ModelAttribute
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(Account account){
        System.out.println(account);
        return "success";
    }

    //ModelAttribute用在类上,先于控制器的方法执行，没有返回值。
    @ModelAttribute
    public void preController2(String name, Map<String,Account> map){
        //模拟查询数据库,用户提交的数据只有少部分，查询数据库将空的字段填充上去
        Account account = new Account();
        account.setId(1);
        account.setMoney(1000f);
        map.put("abc",account);
    }

    //测试ModelAttribute
    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("abc") Account account){
        System.out.println(account);
        return "success";
    }

    //保存model中的数据到session
    @RequestMapping("/saveSession")
    public String saveSession(Model model){
        //默认model中的数据是保存到request域中，但是SessionAttribute会将指定名称的数据放到session中
        model.addAttribute("name","zhangsan");
        model.addAttribute("age",20);
        return "success";
    }

    //获取session的数据
    @RequestMapping("/getSession")
    public String getSession(ModelMap model){
        System.out.println(model.get("name"));
        System.out.println(model.get("age"));
        return "success";
    }

    //删除session的数据
    @RequestMapping("/delSession")
    public String delSession(SessionStatus status){
        status.setComplete();
        return "success";
    }








}
