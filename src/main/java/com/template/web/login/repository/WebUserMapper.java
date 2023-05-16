package com.template.web.login.repository;

import com.template.web.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Mapper
//@Component
public interface WebUserMapper {
//    public Collection<User> findAll();
    @Select("select * from users where id = #{id}")
    public User findById(String id);
//    public void create(User user);
//    public void saveUser(User user);
//    public List<User> findAllUsers();
}
