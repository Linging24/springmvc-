package com.linging.exception;

//自定义异常类
public class MyException extends Exception{

    private String msg;

    public MyException(String message) {
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}