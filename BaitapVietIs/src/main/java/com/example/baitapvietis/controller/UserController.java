package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.repository.UserRepository;
import com.example.baitapvietis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
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
    @GetMapping("/admin")
    public ModelAndView admin(Model model,Principal principal) {
        ModelAndView listUser = new ModelAndView("admin");
        listUser.addObject("listUser", userRepository.findAll());
        return listUser;
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("userUpdate") UserEntity userUpdate, Principal principal){
        UserEntity user = (UserEntity) ((Authentication) principal).getPrincipal();
        user.setName(userUpdate.getName());
        user.setPosition(userUpdate.getPosition());
        user.setDateOfBirth(userUpdate.getDateOfBirth());
        return "UserUpdate";
    }
}
