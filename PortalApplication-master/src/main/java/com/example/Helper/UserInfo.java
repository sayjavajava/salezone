package com.example.Helper;

import com.example.Domain.Roles;
import com.example.Domain.user;

import java.util.List;

/**
 * Created by kamran on 7/22/2017.
 */
 public class UserInfo {

    List<user> userlist;
    List<Roles> roleList;

    public UserInfo(List<user> userlist, List<Roles> roleList) {
        this.userlist = userlist;
        this.roleList = roleList;
    }

    public List<user> getUserlist() {
        return userlist;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }
}
