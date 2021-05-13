package com.t_systems.ecare.eCare.DTO;

import com.t_systems.ecare.eCare.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String userLogin;
    private String userPassword;
    private boolean userBlocked;
    private Set<Role> userRoles;



    public void setUserRole(Role roleCustomer) {
        if(this.userRoles==null)
            this.userRoles=new HashSet<>();
        this.userRoles.add(roleCustomer);
    }

//User
}
