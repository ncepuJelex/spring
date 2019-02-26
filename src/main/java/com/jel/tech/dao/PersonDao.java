package com.jel.tech.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jelex.xu
 * @create 2019-02-16 00:10
 **/
@Repository
public class PersonDao {

    private String id = "1";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDao{" +
                "id='" + id + '\'' +
                '}';
    }
}
