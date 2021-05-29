package com.t_systems.ecare.eCare.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.t_systems.ecare.eCare.entity.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotTariffServiceImpl implements HotTariffService{
    @Autowired
    MessageSender messageSender;
    @Autowired
    TariffService tariffService;

    @Override
    public void sendMessage() {
        messageSender.sendMessage(buildJson());
    }

    private String buildJson() {
        List<Tariff> tariffList = tariffService.getLast(3);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(tariffList);
    }
}
