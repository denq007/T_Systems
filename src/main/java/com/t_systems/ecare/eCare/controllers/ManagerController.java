package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
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


    @RequestMapping("/employeecabinet")
    public String showManagerCabinet(Model model)
    {
        return "employee/employeeCabinet";
    }
  /*  @GetMapping("/showcustomerinformation/{}")
    public String showCustomer( @RequestParam("id") int id,Model model)
    {
        CustomerDTO customerDTO=customerService.findById(id);
        model.addAttribute("customer",customerDTO);
        return "customer/showCustomer";
    }*/
    @GetMapping("/showcustomerinformation/{}")
    public String showCustomer( @RequestParam("login") String login,Model model)
    {
        CustomerDTO customerDTO=customerService.getCustomerDTOByEmailUser(login);
        model.addAttribute("customer",customerDTO);
        return "customer/showCustomer";
    }

/*    @GetMapping("/editcustomer")
    public String editClient(@RequestParam("customerID") int id, Model model) {

        model.addAttribute("customer",customerService.findById(id));
        return "customer/createCustomer";
    }

    @PostMapping("/editcustomer")
    public String editClient(@ModelAttribute("customer") CustomerDTO customerDTO , Model model ) {
        Optional<String> error = customerService.update(customerDTO);
        if (error.isPresent()) {
            model.addAttribute("customer", customerDTO);
            return "customer/createCustomer";
        }
        return "redirect:/employee/showcustomerinformation/{}";
    }*/

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
        return "redirect:employee/all-customer";
    }

    @GetMapping("/user/block")
    public String blockContract(@RequestParam("id") int id, Model model) {
        userService.blockByEmployee(id);
        return "";
    }

    @GetMapping("/user/unblock")
    public String unblockContract(@RequestParam("id") int id, Model model) {
        userService.unblockByEmployee(id);
        return "";
    }

    @GetMapping("/findClientByPhoneNumber")
    public String findByPhoneNumber(@RequestParam(value = "number") String phone,Model model) {
        CustomerDTO customerDTO= customerService.findByPhoneNumber(phone);
        model.addAttribute("customer",customerDTO);
        return "redirect:/customer/showcustomerinformation";
    }


}
