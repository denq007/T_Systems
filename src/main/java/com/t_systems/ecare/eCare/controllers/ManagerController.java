package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.services.CustomerService;
import com.t_systems.ecare.eCare.services.ManagerService;
import com.t_systems.ecare.eCare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employee")
public class ManagerController {

    @Autowired
    private ManagerService managerService ;
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;

    @RequestMapping("/showallcustomer")
    public String showAllCustomer(Model model) {
        List<CustomerDTO> listCustomer= managerService.getAllCustomer();
        model.addAttribute("allCustomer",listCustomer);
        return "employee/all-customer";
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

    @GetMapping("/user/block")
    public String blockContract(@RequestParam("id") int id, Model model) {
        userService.block(id);
        return "";
    }

    @GetMapping("/user/unblock")
    public String unblockContract(@RequestParam("id") int id, Model model) {
        userService.unblock(id);
        return "";
    }

    @GetMapping("/findClientByPhoneNumber")
    public String findByPhoneNumber(@RequestParam(value = "number") String phone,Model model) {
        CustomerDTO customerDTO= customerService.findByPhoneNumber(phone);
        model.addAttribute("customer",customerDTO);
        return "redirect:/customer/showcustomerinformation";
    }


}
