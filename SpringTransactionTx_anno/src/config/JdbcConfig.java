package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
/*
连接数据库的配置类
*/
public class JdbcConfig {
    @Bean(name = "jdbcTemplate")//将jdbcTemplate注入容器
    public JdbcTemplate createJdbcTeplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "dataSource")//将数据源dataSource注入容器
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/up1");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
