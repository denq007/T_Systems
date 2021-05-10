package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.Role;
import com.t_systems.ecare.eCare.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        userEntity.setPassword(passwordEncoder.encode(userDto.getUserPassword()));
        return userEntity;
    }




    @Transactional
    public Optional<String> saveUser(UserDTO user) {
        User fromDB = userDao.getUserByUsername(user.getUserLogin());
        if (fromDB != null) {
            return Optional.of("This user is already registered");
        }
        fromDB = new User();
        fromDB.setRole(Role.ROLE_CUSTOMER);
        fromDB.setPassword(passwordEncoder.encode(user.getUserPassword()));
        fromDB.setLogin(user.getUserLogin());
        user.setUserId(fromDB.getId());
        Customer customer = new Customer();
        customer.setUser(fromDB);
        customerDAO.save(customer);
        return Optional.empty();
    }

    public void findUserByName(User user) {
        User fromDB = userDao.getUserByUsername(user.getLogin());
    }

    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while login " + e.getMessage());
        }
    }
}
