package com.linging.动态代理;

import com.linging.service.AccountService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class CglibProxy {

    public Object getProxy(final AccountService accountService){
        return Enhancer.create(accountService.getClass(), new MethodInterceptor() {

            /**
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法对象
             * @param args 执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib记录日志.....");
                Object returnVal = null;
                returnVal = method.invoke(accountService, args);
                System.out.println("cglib再次记录日志.....");
                return returnVal;
            }
        });
    }
}
