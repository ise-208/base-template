package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebLoginServiceImpl implements WebLoginService {
    @Autowired
    private UserRepository userRepository;

    public WebLoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        WebUser user = new WebUser();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        userRepository.save(user);

    }

    @Override
    public WebUser findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<WebUser> users = userRepository.findAll();
        return users
                .stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(WebUser user) {
        UserDto userDto = new UserDto();
        String[] strings = user.getName().split(" ");
        userDto.setFirstName(strings[0]);
        userDto.setLastName(strings[1]);
        return userDto;
    }
}
