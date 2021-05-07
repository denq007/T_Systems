package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.User;
import com.t_systems.ecare.eCare.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @RequestMapping("/showcustomerinformation")
    public String editCustomer( Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomerDTO customerDTO=customerService.getCustomerDTOwithoutContractsByEmailUser(auth.getName());
         model.addAttribute("customer",customerDTO);
        return "customer/createCustomer";
    }

    /*@GetMapping("/editcustomer")
    public String editClient(@RequestParam("customer") CustomerDTO customerDTO, Model model) {
      //  CustomerDTO customerDTO=customerService.getCustomerDTOwithoutContracts(id);
     //  model.addAttribute("customer", customerDTO);
        return "customer/createCustomer";
    }*/

    @PostMapping("/editcustomer")
    public String editClient(@ModelAttribute("customer")  CustomerDTO dto, Model model, RedirectAttributes attr) {
        Optional<String> error = customerService.update(dto);
        attr.addAttribute("id", dto.getCustomerID());
        return "redirect:/showcustomerinformation";
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
