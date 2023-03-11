package com.template.web.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebMvnConfig {
    public void addViewerController(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/register").setViewName("register");
    }
}
