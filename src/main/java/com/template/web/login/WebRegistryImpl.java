package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebRegistryImpl implements WebRegistry {
    @Autowired
    private WebUserRepository webUserRepository;

    public WebRegistryImpl(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        WebUser user = new WebUser();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        webUserRepository.save(user);

    }


    @Override
    public List<UserDto> findAllUsers() {
        List<WebUser> users = webUserRepository.findAll();
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
