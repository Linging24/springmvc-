package com.linging.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * spring的主配置类
 */
@Configuration  //配置类
@EnableAspectJAutoProxy //开始注解aop的支持
@Import(JdbcConfig.class)   //导入其他配置类
@ComponentScan("com.linging") //组件扫描，创建spring容器时扫描的包，并创建对象放入容器中
@PropertySource("classpath:jdbc.properties") //读取类路径下的properties文件
public class SpringBeanConfg {

    @Value("${jdbc.driver}")    //注入驱动
    private String driver;
    @Value("${jdbc.url}")       //注入url
    private String url;
    @Value("${jdbc.username}")  //注入username
    private String username;
    @Value("${jdbc.password}")  //注入password
    private String password;

    /**
     * 数据源1
     * @return
     */
    @Bean
    @Scope("prototype") //多例，防止多线程下多个mapper对同一数据源的使用互相干扰，存在一个线程还没有使用完，另一个线程就开始使用
    public DataSource dataSource1() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException("数据源创建失败！");
        }
    }


    /**
     * 数据源2
     * @return
     */
    @Bean
    @Scope("prototype")
    public DataSource dataSource2() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException("数据源创建失败！");
        }
    }
}
