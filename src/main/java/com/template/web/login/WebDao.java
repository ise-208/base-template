package com.template.web.login;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebDao {
    private JdbcTemplate jdbcTemplate;


    public WebDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WebUser> findById (String id) {
        String query = "SELECT * FROM user_history " + "WHERE id = '" + id +"' ;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(WebUser.class));
    }

    public void createUser(){
        String query = "INSERT INTO user_history(id, name, password, role) VALUES( 'user3', 'three', 'password', 'ROLE_ADMIN');";
        jdbcTemplate.query(query, new BeanPropertyRowMapper<>(WebUser.class));

        System.out.println(findById("user2"));
        return;
    }
}
