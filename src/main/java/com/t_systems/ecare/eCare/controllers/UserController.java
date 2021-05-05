package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.User;
import com.t_systems.ecare.eCare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
//@RequestMapping("/user")
public class UserController {
    private static final String MESSAGE = "message";
    private static final String SIGN_UP = "sign-up";
    @Autowired
    UserService userService;

    @GetMapping("/user/registration")
    public String registrationUser(Model model)
    {
        UserDTO user=new UserDTO();
        model.addAttribute("user",user);
        return "registrationUser";
    }
    @PostMapping("/user/saveuser")
    public String addUser(@ModelAttribute("user") UserDTO user,Model model)
    {
        Optional<String> error=userService.saveUser(user);
        if (error.isPresent()) {
            model.addAttribute(MESSAGE, error.get());
            return SIGN_UP;
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public ModelAndView signIn(String error)
    {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject(MESSAGE, "Wrong login or password");
        }
        return model;
    }

  /*  @PostMapping("/login")
    public String login(@ModelAttribute("usersign-in")User user)
    {
        userService.findUserByName(user);
        return "redirect:/login";
    }*/

}
