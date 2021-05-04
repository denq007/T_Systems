package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.entity.Role;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(User user)
    {
        User fromDB=userDao.getUserByUsername(user.getLogin());
        if(fromDB!=null)
        {

        }
        fromDB=new User( );
        fromDB.setRole(Role.CUSTOMER);
        fromDB.setId(user.getId());
        fromDB.setPassword(passwordEncoder.encode(user.getPassword()));
        fromDB.setLogin(user.getLogin());
        userDao.save(fromDB);
    }
    public void findUserByName(User user)
    {
        User fromDB= userDao.getUserByUsername(user.getLogin());
    }
}
