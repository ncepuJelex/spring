package com.jel.tech.service;

import com.jel.tech.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:10
 **/
@Service
public class PersonService {

//    @Qualifier("personDao")
//    @Autowired(required = false)
    @Resource(name = "personDao2")
    private PersonDao personDao;

    public void print() {
        System.out.println(personDao);
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
