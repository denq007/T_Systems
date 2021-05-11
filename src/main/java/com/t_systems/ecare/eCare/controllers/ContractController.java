package com.t_systems.ecare.eCare.controllers;
import com.t_systems.ecare.eCare.DTO.ContractDTO;
import com.t_systems.ecare.eCare.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class ContractController {
    @Autowired
    ContractService contractService;

 @GetMapping("/contract/createcontract")
 public String createContract(@RequestParam("customerID")int customerID, Model model)
 {
     ContractDTO contractDTO=new ContractDTO(customerID);
     model.addAttribute("contract",contractDTO);
     contractService.showTariffandOptions(contractDTO);//for show all tariffs and options in jsp
     return "contract/createContract";
 }
    @PostMapping("/contract/createcontract")
    public String editClient(@ModelAttribute("contract") ContractDTO contractDTO , Model model  /*RedirectAttributes attr*/) {
      int i=0;
        Optional<String> error=contractService.update(contractDTO);
        if (error.isPresent()) {
            model.addAttribute("contract", contractDTO);
            return "customer/createCustomer";
        }
        /*  attr.addAttribute("id", customerDTO.getCustomerID());*/
        return "redirect:/customer/showcustomerinformation";
    }

    @GetMapping("/contract/showcontract")
            public String showContract(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("contract", contractService.getDto(id));
        return "contract/showContract";
    }
}
