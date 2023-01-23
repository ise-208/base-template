package com.template.web.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "home")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
//        UserDetails userDetails = User.withDefaultPasswordEncoder().build(); //todo 非推奨のため代替案の検討
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user1 = User.withUsername("user1")
                .password(encoder.encode(""))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1);
    }

    private String bcryptPasswordEncoder(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
