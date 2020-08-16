package com.linging.动态代理;

import com.linging.service.AccountService;
import com.linging.util.ConnectionUtils;
import com.linging.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
@Component
public class JDKProxy {

    //使用jdk动态代理对AccountService的方法进行添加日志的功能
    public Object getProxy(final AccountService accountService){
        /**
         * ClassLoader：和被代理对象使用相同的类加载器。
         * Interfaces：和被代理对象具有相同的行为。实现相同的接口。
         * InvocationHandler：如何代理。
         */
        return Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象的引用，不一定每次都用到
             * @param method  当前执行的方法对象
             * @param args 执行方法所需的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk记录日志.......");
                Object returnVal = null;
                returnVal = method.invoke(accountService,args);
                System.out.println("jdk再次记录日志......");
                return returnVal;
            }
        });
    }

    @Autowired
    private TransactionManager transactionManager;

    /**
     * 使用jdk动态代理对AccountService的方法进行事务控制
     * @param accountService
     * @return
     */
    public Object getProxyTx(final AccountService accountService){
        return Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnVal = null;
                try{
                    //1.开启事务
                    transactionManager.beginTransaction();
                    //2.执行操作
                    returnVal = method.invoke(accountService,args);
                    //3.提交事务
                    transactionManager.commit();
                }catch (Exception e){
                    //4.回滚事务
                    transactionManager.rollback();
                    e.printStackTrace();
                }finally {
                    //5.释放连接
                    transactionManager.close();
                }
                return returnVal;
            }
        });
    }
}
