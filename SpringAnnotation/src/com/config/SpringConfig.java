package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource(value = "classpath:jdbc.properties")
//@Import(JdbcConfig.class)
public class SpringConfig {
    public SpringConfig() {
        System.out.println("Spring环境初始化成功");
    }
}
