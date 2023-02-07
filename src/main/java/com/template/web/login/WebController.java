package com.template.web.login;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class WebController {
    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
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
