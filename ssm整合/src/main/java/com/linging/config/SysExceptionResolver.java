package com.linging.config;

import com.linging.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常处理器类，实现HandlerExceptionResolver接口
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException my = null;
        if(e instanceof MyException){
            my = (MyException) e;
        }else{
            my = new MyException(e.getMessage());
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",my.getMsg());
        mv.setViewName("error");
        return mv;
    }
}