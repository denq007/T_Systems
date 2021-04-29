package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/registration")
    public String registrationUser(Model model)
    {
        User user=new User();
        model.addAttribute("user",user);
        return "registrationUser";
    }

    @RequestMapping("/sign-in")
    public String signIn()
    {
        return "sign-in";
    }

}
