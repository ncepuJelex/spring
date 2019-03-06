package com.jel.tech.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author jelex.xu
 * @create 2019-03-06 22:59
 **/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {

        String sql = "insert into t_user(user_name, age) values(?, ?)";
        jdbcTemplate.update(sql, "zs" + Math.random(), 19);
    }
}
