package com.t_systems.ecare.eCare.controllers;

import com.t_systems.ecare.eCare.services.HotTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotTariffController {
    @Autowired
    HotTariffService hotTariffService;
    @GetMapping("/hotTariffs")
    public String sendMessage()
    {
        hotTariffService.sendMessage();
        return "";
    }


}
