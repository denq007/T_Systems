package com.t_systems.ecare.eCare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllers {
    @RequestMapping("/")
    public String showFirstView() {
        return "home";
    }
}
