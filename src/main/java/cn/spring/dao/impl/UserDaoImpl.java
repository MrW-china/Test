package cn.spring.dao.impl;

import cn.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save ( ) {
        System.out.println(12345);
    }
}
