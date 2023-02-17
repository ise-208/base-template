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
import java.util.List;


@Service
public class WebLoginDetailService implements UserDetailsService {
    @Autowired
    private WebDao webDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser user;
        try {
            user = webDao.findById(username).get(0);
            System.out.println(username);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
            grantedAuthorities.add(authority);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            UserDetails userDetails = new User(user.getName(), encoder.encode(user.getPassword()),grantedAuthorities);
            return userDetails;
        } catch (Exception e){
            throw new UsernameNotFoundException("error");
        }
    }
}
