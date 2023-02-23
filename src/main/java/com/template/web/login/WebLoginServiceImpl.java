package com.template.web.login;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebLoginServiceImpl implements WebLoginService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public WebLoginServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void saveUser(UserDto userDto) {
        WebUser user = new WebUser();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        WebRole role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null){
            role = null;
        }
        user.setRole(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public WebUser findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDto> findAllUsers(){
        List<WebUser> users = userRepository.findAll();
        return users
                .stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(WebUser user){
        UserDto userDto = new UserDto();
        String[] strings = user.getName().split(" ");
        userDto.setFirstName(strings[0]);
        userDto.setLastName(strings[1]);
        return userDto;
    }

    private WebRole checkRoleExist(){
        WebRole role = new WebRole();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

}
