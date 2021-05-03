package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.entity.User;

public interface UserService {
    public void saveUser(User user);
    public void findUserByName(User user);
}
