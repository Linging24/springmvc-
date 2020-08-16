package com.linging.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务相关的工具类，包括了开启事务、提交事务、回滚事务、释放连接功能
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public void close(){
        try {
            connectionUtils.getThreadConnection().close();  //把连接还回连接池
            connectionUtils.remove();   //解除ThreadLocal中的连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 环绕通知，由于注解方式的执行顺序有问题，使用环绕通知可以解决
     *//*
    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp){
        try {
            //开启事务
            beginTransaction();
            //执行操作
            pjp.proceed();
            //提交事务
            commit();
        } catch (Throwable throwable) {
            //回滚事务
            rollback();
            throwable.printStackTrace();
        }finally {
            //释放资源
            close();
        }
    }*/

}
