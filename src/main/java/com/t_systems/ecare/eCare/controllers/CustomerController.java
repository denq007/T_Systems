package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @GetMapping("/showcustomerinformation")
    public String showCustomer( Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomerDTO customerDTO=customerService.getCustomerDTOwithoutContractsByEmailUser(auth.getName());
         model.addAttribute("customer",customerDTO);
        return "customer/showCustomer";
    }

    @GetMapping("/editcustomer")
    public String editClient(@RequestParam("customerID") int id, Model model) {

        model.addAttribute("customer",customerService.findById(id));
        return "customer/createCustomer";
    }

    @PostMapping("/editcustomer")
    public String editClient(@ModelAttribute("customer") CustomerDTO customerDTO , Model model  /*RedirectAttributes attr*/) {

        Optional<String> error = customerService.update(customerDTO);
        if (error.isPresent()) {
            model.addAttribute("customer", customerDTO);
            return "customer/createCustomer";
        }
      /*  attr.addAttribute("id", customerDTO.getCustomerID());*/
        return "redirect:/customer/showcustomerinformation";
    }





    @RequestMapping("/showcontract")
    public String showContract()
    {
        return null;
    }

   /* @GetMapping("{id}")
    public String customerEditInformation(@PathVariable int id, Model model)
    {
        return null;
    }*/
}
