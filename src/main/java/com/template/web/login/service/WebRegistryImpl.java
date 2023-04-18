package com.template.web.login.service;

import com.template.web.login.entity.User;
import com.template.web.login.repository.WebUserMapper;
import com.template.web.login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebRegistryImpl implements WebUserMapper {
    @Autowired
    private WebUserMapper webUserMapper;

    public WebRegistryImpl(WebUserMapper webUserMapper) {
        this.webUserMapper = webUserMapper;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        webUserMapper.create(user);

    }


    @Override
    public List<UserDto> findAllUsers() {
        Collection<User> users = webUserMapper.findAll();
        return users
                .stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] strings = user.getName().split(" ");
        userDto.setFirstName(strings[0]);
        userDto.setLastName(strings[1]);
        return userDto;
    }
}
