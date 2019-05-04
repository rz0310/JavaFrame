package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.renjing")
@EnableAspectJAutoProxy//开启spring对注解aop的支持
public class SpringConfiguration {

}
