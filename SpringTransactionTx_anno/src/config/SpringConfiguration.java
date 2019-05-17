package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
Spring的配置类，作用就是当bean.xml用
*/
@Configuration//声明为配置类
@ComponentScan("com.renjing")//要扫描的包
@Import({JdbcConfig.class,TransactionManager.class})//导入其他配置类
@EnableTransactionManagement//配置开启Spring注解事务的支持
public class SpringConfiguration {

}
