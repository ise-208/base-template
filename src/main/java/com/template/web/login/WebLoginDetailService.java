package com.template.web.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class WebLoginDetailService implements UserDetailsService {
    private WebLoginDao webLoginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        WebLoginUser webLoginUser = webLoginDao.findById(username).get(0);
        WebUser user = null;
        try {
//
        } catch (Exception e){
            throw new UsernameNotFoundException("error");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(authority);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails userDetails = new User(user.getName(), encoder.encode(user.getPassword()),grantedAuthorities);
        return userDetails;
    }
}
