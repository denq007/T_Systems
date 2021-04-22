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
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Option.class)
                .addAnnotatedClass(Tariff.class)
                .buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Option option=new Option("unlInternet",50.00,0.00);
        Tariff firstTariff=new Tariff("unlimited",123.99);
        firstTariff.addOptionToTariff(option);
      Customer firstCustomer=new Customer("Ivan","Ivanov", LocalDate.of(2017, Month.NOVEMBER, 30),"1234 987654 SPb TP№70"
                ,"Spb,Planernay 71,86","aasd.spb@mail.ru","12345",true);
        Contract firstContract=new Contract("89500148710", firstTariff,firstCustomer);

        firstCustomer.addContractToCustumer(firstContract);
     //   System.out.println(firstCustomer.getContractIdList());

  //      firstContract.addOptionToContract(option);
        session.beginTransaction();
        session.persist(option);
        session.persist(firstTariff);
        session.persist(firstContract);
        session.persist(firstCustomer);
        session.getTransaction().commit();
        session.close();
    }
}
