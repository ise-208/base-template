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
    private UserRepository userRepository;
    public WebLoginDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        WebUser user = userRepository.findById(id);
        if (id == null || "".equals(id)) {
            throw new UsernameNotFoundException("Username is empty");
        }
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(authority);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            UserDetails userDetails = new User(user.getName(), encoder.encode(user.getPassword()),grantedAuthorities);
            System.out.println(userDetails.toString());
            return userDetails;        }
    }

}
