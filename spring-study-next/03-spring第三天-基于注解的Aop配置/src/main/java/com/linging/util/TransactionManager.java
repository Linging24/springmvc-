package com.linging.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务相关的工具类，包括了开启事务、提交事务、回滚事务、释放连接功能
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.linging.service.impl.*.*(..))")
    public void pointCut(){}


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
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp){
        Object returnVal = null;
        try {
            //1.开启事务
            beginTransaction();
            //2.执行操作
            Object[] args = pjp.getArgs();  //获取参数
            returnVal = pjp.proceed(args);
            //3.提交事务
            commit();
        } catch (Throwable throwable) {
            //4.回滚事务
            rollback();
            throwable.printStackTrace();
        }finally {
            //5.释放资源
            close();
        }
        return returnVal;
    }

}
