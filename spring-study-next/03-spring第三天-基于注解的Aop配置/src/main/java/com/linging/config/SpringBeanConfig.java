package com.linging.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JdbcConfig.class})
@ComponentScan("com.linging")
@EnableAspectJAutoProxy //开启spring对Aop注解的支持
public class SpringBeanConfig {
}
