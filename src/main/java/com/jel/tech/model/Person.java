package com.jel.tech.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author jelex.xu
 * @create 2019-02-15 23:57
 **/
public class Person {

    @Value("张三")
    private String name;

    @Value("#{30-3}")
    private int age;

    @Value("${person.nickName}")
    private String nickName;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
