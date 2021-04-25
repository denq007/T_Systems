package com.t_systems.ecare.eCare.DAO;


import com.t_systems.ecare.eCare.entity.Contract;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class ContractDAOImpl implements ContractDAO{

   private SessionFactory sessionFactory;

    @Override
    public List<Contract> getAllContracts() {
        return null;
    }

    @Override
    public Contract getContract(int id) {
        return null;
    }

}
