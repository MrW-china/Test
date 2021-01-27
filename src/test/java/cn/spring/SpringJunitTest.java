package cn.spring;

import cn.spring.config.SpringConfiguration;
import cn.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @Test
    public void test1 ( ) throws Exception {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
//        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
