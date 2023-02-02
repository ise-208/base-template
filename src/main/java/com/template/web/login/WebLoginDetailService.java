package com.template.web.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WebLoginDetailService implements UserDetailsService {
//    private WebLoginDao webLoginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        WebLoginUser webLoginUser = webLoginDao.findById(username).get(0);
        return null;
    }
}
