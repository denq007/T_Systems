package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractHibernateDAO{
    public UserDao() {
        setClazz(User.class);
    }
}
