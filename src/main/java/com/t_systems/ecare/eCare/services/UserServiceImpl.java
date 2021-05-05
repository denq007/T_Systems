package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Role;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public Optional<String> saveUser(UserDTO user)
    {
        User fromDB=userDao.getUserByUsername(user.getUserLogin());
        if(fromDB!=null)
        {
            return Optional.of("This user is already registered");
        }
        fromDB=new User( );
        fromDB.setRole(Role.CUSTOMER);
       // fromDB.setId(user.getUserId());
        fromDB.setPassword(passwordEncoder.encode(user.getUserPassword()));
        fromDB.setLogin(user.getUserLogin());
        userDao.save(fromDB);
        user.setUserId(fromDB.getId());
        user.setUserPassword(null);
        return Optional.empty();
    }
    public void findUserByName(User user)
    {
        User fromDB= userDao.getUserByUsername(user.getLogin());
    }
}
