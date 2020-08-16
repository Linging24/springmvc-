package com.linging.config;

import com.linging.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * jdbc的配置类
 */
@Configuration
public class JdbcConfig {

/*    @Bean
    public QueryRunner queryRunner(@Qualifier("dataSource1") DataSource dataSource){
        return new QueryRunner(dataSource);
    }*/

    //使用自定义事务管理器，不需要设置数据源
    @Bean
    public QueryRunner queryRunner(){
        return new QueryRunner();
    }

}
