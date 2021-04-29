package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void saveUser(User user)
    {
        userDao.save(user);
    }
}
