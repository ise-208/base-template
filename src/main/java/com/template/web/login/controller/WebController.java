package com.template.web.login.controller;

import com.template.web.login.repository.WebRegistry;
import com.template.web.login.entity.WebUser;
import com.template.web.login.repository.WebUserRepository;
import com.template.web.login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private WebRegistry webRegistry;

    @Autowired
    private WebUserRepository userRepository;

    public WebController(WebRegistry webRegistry) {
        this.webRegistry = webRegistry;
    }

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

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/regester/save")
    public String registration(@Validated @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        WebUser user = userRepository.findById(userDto.getId());
        webRegistry.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = webRegistry.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


}
