package com.linging.controller;

import com.linging.execption.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception()throws Exception{
        try{
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("出现错误了.....");
        }
        return "success";
    }

}
