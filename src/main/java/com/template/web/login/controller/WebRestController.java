package com.template.web.login.controller;

import com.template.web.login.repository.WebUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpHeaders;


@RestController
@RequestMapping("/")
public class WebRestController {

    @Autowired
    private WebUserMapper repository;

    private Logger  log = LoggerFactory.getLogger(WebController.class);

    private HttpHeaders createHeader(){return null;}

    @RequestMapping("/example")
    public String example(ModelAndView modelAndView){
        return "example";
    }

}
