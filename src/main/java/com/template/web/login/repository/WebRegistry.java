package com.template.web.login.repository;

import com.template.web.login.dto.UserDto;

import java.util.List;

public interface WebRegistry {
    void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();
}
