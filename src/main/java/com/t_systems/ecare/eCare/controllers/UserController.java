package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.entity.User;
import com.t_systems.ecare.eCare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registrationUser(Model model)
    {
        User user=new User();
        model.addAttribute("user",user);
        return "registrationUser";
    }
    @PostMapping("/saveuser")
    public String addUser(@ModelAttribute("user") User user)
    {
        userService.saveUser(user);
        return "home";
    }

    @RequestMapping("/sign-in")
    public String signIn()
    {
        return "sign-in";
    }

}
