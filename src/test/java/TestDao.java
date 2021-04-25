import org.hibernate.SessionFactory;
import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    static SessionFactory sessionFactory=new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Contract.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Option.class)
            .addAnnotatedClass(Tariff.class)
            .buildSessionFactory();

    Session session=sessionFactory.getCurrentSession();

    @Test
    public void addNewOption()
    {
        
    }
    @Test
    public void addNewCustomer()
    {

    }
}
