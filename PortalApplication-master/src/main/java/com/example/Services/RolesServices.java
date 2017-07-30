package com.example.Services;

import com.example.Domain.Roles;
import com.example.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamran on 7/22/2017.
 */
@Service
public class RolesServices {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> allroles(){
        return  rolesRepository.findAll();
    }
    public void saveRoles(Roles roles){
        rolesRepository.save(roles);
    }
}
