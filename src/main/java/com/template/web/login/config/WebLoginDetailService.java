package com.template.web.login.config;

import com.template.web.login.entity.User;
import com.template.web.login.repository.WebUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private WebUserMapper webUserMapper;

    @Override
    public UserDetails loadUserByUsername(String id) {
        User user = webUserMapper.findById(id);

        return user;
//        if (id == null || "".equals(id)) {
//            throw new UsernameNotFoundException("Username is empty");
//        }
//        if (user == null){
//            throw new UsernameNotFoundException("User not found");
//        } else {
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//            GrantedAuthority authority = new SimpleGrantedAuthority("USER");
//            grantedAuthorities.add(authority);
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            return new org.springframework.security.core.userdetails.User(user.getName(), encoder.encode(user.getPassword()),grantedAuthorities);
//        }
    }

}
