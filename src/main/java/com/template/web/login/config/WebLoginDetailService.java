package com.template.web.login.config;

import com.template.web.login.entity.Account;
import com.template.web.login.repository.WebUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Transient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class WebLoginDetailService implements UserDetailsService {
    @Autowired
    private WebUserMapper webUserMapper;

    @Override
    public UserDetails loadUserByUsername(String id) {
        Account account = webUserMapper.findById(id);

        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .disabled(!account.isEnabled())
//                .accountExpired()
                .build();
    }

}
