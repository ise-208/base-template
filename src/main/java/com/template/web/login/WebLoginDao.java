package com.template.web.login;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebLoginDao {
    private final JdbcTemplate jdbcTemplate;

    public WebLoginDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WebLoginUser> findById (String id) {
        String query = "SELECT * FROM user_history" + "WHERE id = " + id;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(WebLoginUser.class));
    }
}
