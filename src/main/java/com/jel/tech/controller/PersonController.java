package com.jel.tech.controller;

import com.jel.tech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:10
 **/
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
}
