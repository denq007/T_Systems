package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDAO extends GenericDAO<Contract>{

    @Autowired
    public void setClass() {
        this.setClass(Contract.class);
    }

}
