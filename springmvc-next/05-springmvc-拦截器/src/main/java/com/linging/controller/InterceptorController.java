package com.linging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/interceptor")
    public String interceptor(){
        System.out.println("控制器执行了.....");
        return "success";
    }

}
