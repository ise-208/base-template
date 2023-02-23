package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WebLoginService {
    void saveUser(UserDto userDto);

    WebUser findUserById(String id);

    List<UserDto> findAllUsers();
}
