package com.example.Domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created by kamran on 8/23/2017.
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    @NotEmpty(message = " name must not be null")
    private String name;

    @NotEmpty(message = "email must not be null")
    private String email;


    @Size(min=11, max=11)
    @NotEmpty(message = "phnumber must not be null")
    private String phnumber;

    @Size(min = 20)
    @NotEmpty(message = "message must not be null")
    private String message;


    public Contact(String name, String email, String phnumber, String message) {
        this.name = name;
        this.email = email;
        this.phnumber = phnumber;
        this.message = message;
    }

    public Contact(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
