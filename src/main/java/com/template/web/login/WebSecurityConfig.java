package com.template.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Set;

@Configuration
@EnableWebSecurity
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
                        .loginProcessingUrl("/sign_in")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successForwardUrl("/hello")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

//
//    protected static class AuthenticationConfiguration
//            extends GlobalAuthenticationConfigurerAdapter {
//
//        @Autowired
//        UserDetailsService userDetailsService;
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            // 認証するユーザーを設定する
//            auth.userDetailsService(userDetailsService)
//                    // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
//                    .passwordEncoder(new BCryptPasswordEncoder());
//
//        }
//    }



    @Bean
    public void userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    }

    private String bcryptPasswordEncoder(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }


}
