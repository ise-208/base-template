package com.template.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpHeaders;


@RestController
@RequestMapping("/")
public class WebRestController {

    @Autowired
    private AccountRepository repository;

    WebDao webDao;
    private Logger  log = LoggerFactory.getLogger(WebController.class);

    private HttpHeaders createHeader(){return null;}

    @RequestMapping("/example")
    public String example(ModelAndView modelAndView){
        return "example";
    }

    @PostMapping("/create")
    public void create(WebUser webUser){
        repository.save(webUser);
        return;
    }
}
