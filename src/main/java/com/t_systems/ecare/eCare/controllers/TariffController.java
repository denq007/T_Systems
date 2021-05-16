package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.entity.Tariff;
import com.t_systems.ecare.eCare.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class TariffController {
    @Autowired
    TariffService tariffService;

    @GetMapping("/employee/create-tariff")
    public String createTariff(Model model)
    {
        TariffDTO tariffDTO=new TariffDTO();
        tariffService.showAllOptions(tariffDTO);
        model.addAttribute("tariff",tariffDTO);
        return "tariff/createTariff";
    }
    @PostMapping("/employee/create-tariff")
    public String createTariff(@ModelAttribute("tariff") TariffDTO tariffDTO, Model model,  RedirectAttributes attr) {
        Optional<String> error = tariffService.saveTariff(tariffDTO);
        if (error.isPresent()) {
            model.addAttribute("message", error.get());
            return "/sign-in";
        }
        attr.addAttribute("name", tariffDTO.getTariffName());
        return "redirect:/show-tariff";
    }
    @GetMapping ("/show-tariff")
    public String showTariff(@RequestParam("name")String name,Model model)
    {
        TariffDTO tariffDTO=tariffService.findTariffByName(name);
        if(tariffDTO ==null)
        {
            model.addAttribute("message", "Tariff not found");
            return "/tariff/showTariff";
        }
        model.addAttribute("tariff",tariffDTO);
        return "/tariff/showTariff";
    }
    @GetMapping("/employee/delete-tariff")
    public String deleteTariff(@RequestParam("name")String name,Model model)
    {
        Optional<String> error = tariffService.deleteTariff(name);
        if (error.isPresent())
        {
            model.addAttribute("message",error.get());
            return "redirect:/employee/employeecabinet";
        }
        return "redirect:/employee/employeecabinet";
    }
    @GetMapping("/edit-tariff")
    public String editTariff(@RequestParam("name")String name,Model model)
    {
        TariffDTO tariffDTO= tariffService.findTariffByName(name);
        if(tariffDTO ==null)
        {
            model.addAttribute("message", "Tariff not found");
            return "/success";
        }
        return null;
    }


}
