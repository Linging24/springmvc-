package com.linging.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * jdbc的配置类
 */
@Configuration
public class JdbcConfig {

    /**
     * 配置JdbcTemplate，当创建springioc容器时，会扫描注解了@bean的方法，并创建对象，放到ioc容器中
     * @param dataSource 数据源，spring会帮我们注入数据源，先按照类型注入，如果存在多个会按照变量名称作为id来查找bean，找到就注入，没有则报错，
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource1") DataSource dataSource){  //方法参数的注入和@Autowired一样
        return new JdbcTemplate(dataSource);
    }
}
