package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
Jdbc的配置类
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean(name = "runner")//它是把方法的返回值存入Spring容器中，该注解有一个属性name，用于指定bean的id。    //当不指定时有默认值，默认值是方法的名称
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource){//在形参中使用Qualifier
        return new QueryRunner(dataSource);
    }
//    注意：这里的name，如果你配置两个dataSource（其中一个名字为dataSource），那么两个都会执行。但是两个dataSource中没有名字为"dataSource"的
//    那么，就会抛出异常。
//    如果只有一个，那么可以随便写name
    @Bean(name = "ds1")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            System.out.println("1");
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
    @Bean(name = "ds2")
    public DataSource createDataSource1(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            System.out.println("1");
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
