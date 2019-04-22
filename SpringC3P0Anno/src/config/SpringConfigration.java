package config;
import org.springframework.context.annotation.*;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
注意：在要使用某个类的方法时，需要将该类注入容器，使用@Component
当不需要使用某个类的方法，只需要用到方法的返回值时，使用@Import，导入配置即可
 */
@Configuration//他就是把当前类看成Spring的配置类
@ComponentScan({"com.renjing","config"})
@Import({JdbcConfig.class})//导入其他配置类
@PropertySource(value="classpath:config/JdbcConfig.properties")//导入properties配置文件
public class SpringConfigration {
//    获取EL表达式的解析器
    @Bean
    public static PropertySourcesPlaceholderConfigurer createPropertySourcePlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
