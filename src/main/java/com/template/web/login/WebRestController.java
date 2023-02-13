package com.template.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.net.http.HttpHeaders;


@RestController
@RequestMapping("/")
public class WebRestController {

    WebLoginDao webLoginDao;
    private Logger  log = LoggerFactory.getLogger(WebController.class);

    private HttpHeaders createHeader(){return null;}

    @RequestMapping("/example")
    public String example(ModelAndView modelAndView){
        return "example";
    }

    @RequestMapping("/create")
    public void create(ModelAndView modelAndView){
        webLoginDao.createUser();
        return;
    }
}
