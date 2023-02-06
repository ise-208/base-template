package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebLoginDao {
    private JdbcTemplate jdbcTemplate;


    public WebLoginDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WebUser> findById (String id) {
        String query = "SELECT * FROM user_history " + "WHERE id = '" + id +"' ;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(WebUser.class));
    }
}
