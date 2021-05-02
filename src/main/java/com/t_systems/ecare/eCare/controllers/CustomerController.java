package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.services.CustomerService;
import com.t_systems.ecare.eCare.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/showallcustomer")
    public String showAllCustomer(Model model) {
    List<Customer> listCustomer= customerService.getAllCustomer();
    model.addAttribute("allCustomer",listCustomer);
    return "all-customer";
    }

    @GetMapping("/addnewcustomer")
    public String addNewCustomer(Model model)
    {
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "addnewcustomer";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer customer)
    {
        customerService.saveCustomer(customer);
        return "home";
    }


}
