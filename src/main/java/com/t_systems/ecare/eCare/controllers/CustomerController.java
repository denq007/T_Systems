package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import com.t_systems.ecare.eCare.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

        @RequestMapping("/showallcustomer")
    public String showAllCustomer(Model model) {
    List<Customer> listCustomer= customerService.getAllCustomer();
    model.addAttribute("allCustomer",listCustomer);
    return "all-customer";
    }

    @RequestMapping("/addnewcostumer")
    public String addNewCustomer(Model model)
    {
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "addnewcostumer";
    }
    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer customer)
    {
        customerService.saveCustomer(customer);
        return "redirect:/showallcustomer";
    }


}
