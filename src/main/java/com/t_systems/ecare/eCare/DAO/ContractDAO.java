package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Contract;

import java.util.List;

public interface ContractDAO {
    public List<Contract> getAllContracts();
    public Contract getContract(int id);
}
