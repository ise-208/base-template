package com.template.web.login.repository;

import com.template.web.login.dto.UserDto;
import com.template.web.login.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface WebUserMapper {
    Collection<User> findAll();
    User findById(String id);
    void create(User user);
    void saveUser(UserDto userDto);
    List<UserDto> findAllUsers();


}
