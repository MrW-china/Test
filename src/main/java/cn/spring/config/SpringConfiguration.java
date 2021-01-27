package cn.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.spring")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
