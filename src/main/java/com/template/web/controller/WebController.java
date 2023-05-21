package com.template.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {
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

    @GetMapping("/general")
    public String general(){
        return "general";
    }

}
