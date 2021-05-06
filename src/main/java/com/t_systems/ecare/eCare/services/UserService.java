package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService {
    public Optional<String> saveUser(UserDTO user);
    public void findUserByName(User user);
    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password);
}
