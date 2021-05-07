package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.services.CustomerService;
import com.t_systems.ecare.eCare.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/employee")
public class ManagerController {

    @Autowired
    private ManagerService managerService ;

    @RequestMapping("/showallcustomer")
    public String showAllCustomer(Model model) {
        List<CustomerDTO> listCustomer= managerService.getAllCustomer();
        model.addAttribute("allCustomer",listCustomer);
        return "manager/all-customer";
    }

    @GetMapping("/addnewcustomer")
    public String addNewCustomer(Model model)
    {
        CustomerDTO customer=new CustomerDTO();
        model.addAttribute("customer",customer);
        return "manager/addnewcustomer";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO customerDTO)
    {
        managerService.saveCustomer(customerDTO);
        return "redirect:manager/all-customer";
    }


}
