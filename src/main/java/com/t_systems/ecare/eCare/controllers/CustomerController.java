package com.t_systems.ecare.eCare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showcustomerinformation")
    public String registrationUser(Model model)
    {
        return "customer/showCustomerInformation";
    }

    @RequestMapping("/showcontract")
    public String showContract()
    {
        return null;
    }

}
