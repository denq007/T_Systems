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
      /*  SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Contract.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Option.class)
                .addAnnotatedClass(Tariff.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Option option=new Option("unlInternet",50.00,0.00);
        Tariff firstTariff=new Tariff("unlimited",123.99);
        firstTariff.addOptionToTariff(option);
        Tariff secondTariff=new Tariff("Best",123.99);
        secondTariff.addOptionToTariff(option);
        Option option1=new Option("call",45.00,0.0);
        secondTariff.addOptionToTariff(option1);
      Customer firstCustomer=new Customer("Ivan","Ivanov", LocalDate.of(2017, Month.NOVEMBER, 30),"1234 987654 SPb TP№70"
                ,"Spb,Planernay 71,86","aasd.spb@mail.ru","12345",1);
        Contract firstContract=new Contract("89500148710", firstTariff,firstCustomer);
        Contract secondContract=new Contract("89500148711",secondTariff,firstCustomer);
        firstCustomer.addContractToCustumer(firstContract);
        firstCustomer.addContractToCustumer(secondContract);
     //   System.out.println(firstCustomer.getContractIdList());

  //      firstContract.addOptionToContract(option);
        session.beginTransaction();
        session.persist(option);
        session.persist(firstTariff);
        session.persist(firstContract);
        session.persist(firstCustomer);
        session.persist(option1);
        session.persist(secondTariff);
        session.persist(secondContract);
        session.getTransaction().commit();
        session.close();*/
    }
}
