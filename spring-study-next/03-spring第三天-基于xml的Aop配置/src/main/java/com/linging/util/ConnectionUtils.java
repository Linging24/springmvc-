package com.linging.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并和当前线程实现绑定
 */
public class ConnectionUtils {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();


    /**
     * 获取线程绑定的连接
     * @return
     */
    public Connection getThreadConnection(){
        try{
            //先从ThreadLocal中获取
            Connection connection = threadLocal.get();
            //为空则从数据源获取连接，并和当前线程绑定
            if(connection == null){
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void remove(){
        threadLocal.remove();
    }


}
