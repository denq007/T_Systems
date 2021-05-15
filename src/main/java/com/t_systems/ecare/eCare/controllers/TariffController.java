package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.entity.Tariff;
import com.t_systems.ecare.eCare.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping("/employee/save-tariff")
    public String createTariff(@RequestParam("tariff") TariffDTO tariffDTO, Model model, HttpServletRequest request, RedirectAttributes attr) {
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
        model.addAttribute("tariff",tariffDTO);
        return "/tariff/showTariff";
    }

}
