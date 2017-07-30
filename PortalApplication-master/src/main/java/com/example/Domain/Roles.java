package com.example.Domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by waqas on 03/03/2017.
 */
@Entity
@Table(name="role")
public class Roles extends AbstractPersistable<Integer>{

    @javax.persistence.Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "role is essential ")
    @Column(name = "role")
    private String role;



@ManyToMany
private Set<user>users;

    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
    }

    public Roles(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Roles(){}

}
