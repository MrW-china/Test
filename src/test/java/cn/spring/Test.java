package cn.spring;


import cn.spring.config.SpringConfiguration;
import cn.spring.dao.UserDao;
import cn.spring.service.UserService;
import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class Test {
//    @Autowired
//    private UserDao userDao;
//    @Resource
//    private UserService userService;
    //userDao
    @org.junit.Test
    public void test1 ( ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }

    //userServie
    @org.junit.Test
    public void test2 ( ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    //c3p0
    @org.junit.Test
    public void test3 ( ) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/spring_boot?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("310515");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //druid
    @org.junit.Test
    public void test4 ( ) throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_boot?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("310515");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //配置文件读取Druid
    @org.junit.Test
    public void test5 ( ) throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(rb.getString("jdbc.driver"));
        dataSource.setUrl(rb.getString("jdbc.url"));
        dataSource.setUsername(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //bean获取dataSource
    @org.junit.Test
    public void test6 ( ) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
