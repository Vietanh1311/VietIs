package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "Login";
    }


    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String home(Model model, UserEntity user) {
        model.addAttribute("user", user);
        return "register";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserEntity user, Model model) {
        userService.add(user);
        return "welcome";
    }
}
