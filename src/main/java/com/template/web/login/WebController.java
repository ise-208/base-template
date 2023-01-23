package com.template.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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


}
