package com.example.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created by kamran on 8/23/2017.
 */
@Entity
public class AndroidAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    @NotEmpty(message = " name must not be null")
    private String name;

    @NotEmpty(message = "city must not be null")
    private String city;


    @NotEmpty(message = "phnumber must not be null")
    private String phnumber;

    @NotEmpty(message = "address must not be null")
    private String customeraddress;

    @NotEmpty(message = "not empty")
     @Column(name = "product_name")
    private String Product_name;





    public  AndroidAddress(){};

    public AndroidAddress(String name, String city, String phnumber, String customeraddress, String product_name) {
        this.name = name;
        this.city = city;
        this.phnumber = phnumber;
        this.customeraddress = customeraddress;
        Product_name = product_name;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }
}