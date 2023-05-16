package com.template.web.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {
//    private final WebUserMapper webUserMapper;
//    public WebController(WebUserMapper webUserMapper) {
//        this.webUserMapper = webUserMapper;
//    }

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView) {
        modelAndView.setViewName("logout");
        return modelAndView;
    }

    @RequestMapping("/hello")
    @Secured({"ROLE_USER"})
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
