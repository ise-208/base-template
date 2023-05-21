package com.template.web.config;

import com.template.web.entity.Account;
import com.template.web.repository.WebUserMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class WebLoginDetailService implements UserDetailsService {
    @Autowired
    private WebUserMapperRepository webUserMapperRepository;

    @Override
    public UserDetails loadUserByUsername(String id) {
        Account account = webUserMapperRepository.findById(id);

        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .disabled(!account.isEnabled())
                .build();
    }

}
