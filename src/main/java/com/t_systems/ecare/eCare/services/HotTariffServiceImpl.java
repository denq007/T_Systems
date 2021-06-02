package com.t_systems.ecare.eCare.services;


import com.t_systems.ecare.eCare.DAO.TariffDAO;
import com.t_systems.ecare.eCare.entity.Tariff;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
/*@DependsOn("messageSender")*/
public class HotTariffServiceImpl implements HotTariffService {
    @Autowired
    MessageSender messageSender;
    @Autowired
    TariffService tariffService;

    @Override
    public void sendMessage() {
        messageSender.sendMessage(build());
    }

    private String build() {
        List<Tariff> tariffList = tariffService.getLast(3);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(tariffList);
    }

    @PostConstruct
    public void postConstruct() {
        sendMessage();
    }
}
