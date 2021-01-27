package cn.spring.service.impl;

import cn.spring.dao.UserDao;
import cn.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
//    public void setUserDao(UserDao userDao){
//        this.userDao=userDao;
//    }
    public void save ( ) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }
}
