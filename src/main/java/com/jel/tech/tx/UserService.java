package com.jel.tech.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jelex.xu
 * @create 2019-03-06 22:58
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add() {

        userDao.insert();
        System.out.println("ok");
        int i = 10 /0;
    }
}
