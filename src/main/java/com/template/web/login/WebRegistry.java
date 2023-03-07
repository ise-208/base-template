package com.template.web.login;

import java.util.List;

public interface WebRegistry {
    void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();
}
