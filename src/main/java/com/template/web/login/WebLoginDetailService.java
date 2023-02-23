package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WebLoginDetailService implements UserDetailsService {
    @Autowired
    private WebDao webDao;

    @Autowired
    private UserRepository repository;

    public WebLoginDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        WebUser user = repository.findById(id);
        if (id == null || "".equals(id)) {
            throw new UsernameNotFoundException("Username is empty");
        }
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        } else {
            return new User(user.getId(), user.getPassword(), mapRolesToAuth(user.getRoles()));
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuth(Collection <WebRole> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
