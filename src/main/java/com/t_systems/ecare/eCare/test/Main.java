package com.t_systems.ecare.eCare.test;

import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Contract.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Option option=new Option("unlimited Internet",50.00,0.00,new ArrayList<>());
        List<Option> firstListOption=new ArrayList<>();
        firstListOption.add(option);
        Tariff firstTariff=new Tariff("unlimited",123.99,firstListOption);
        Contract firstContract=new Contract("89500148710", firstTariff,firstListOption);
        List<Contract>firstListContract=new ArrayList<>();
        firstListContract.add(firstContract);
        Customer firstCustomer=new Customer("Ivan","Ivanov", LocalDate.of(2017, Month.NOVEMBER, 30),"1234 987654 SPb TP№70"
        ,"Spb,Planernay 71,86",firstListContract,"aasd.spb@mail.ru","12345",true);

        session.beginTransaction();
        session.save(option);
        session.save(firstTariff);
        session.save(firstContract);
        session.save(firstCustomer);
        session.getTransaction().commit();

    }
}
