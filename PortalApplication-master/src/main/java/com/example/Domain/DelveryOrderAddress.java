package com.example.Domain;

/**
 * Created by kamran on 8/19/2017.
 */


import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

    /**
     * Created by kamran on 8/19/2017.
     */


    @Entity
    public class DelveryOrderAddress {
/*@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;*/

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;



        @NotEmpty(message = " name must not be null")
        private String name;

        @NotEmpty(message = "city must not be null")
        private String city;

        @Digits(integer=10, fraction=0,message = "phone number should be valid")
        @Size(min=11, max=11)
        @NotEmpty(message = "phnumber must not be null")
        private String phnumber;

        @Size(min = 20)
        @NotEmpty(message = "address must not be null")
        private String customeraddress;



/*
        @OneToMany(mappedBy = "address", cascade=CascadeType.ALL)
        public Set<OrderDetail> orderDetails =new HashSet<OrderDetail>();
*/




      /*  public Set<OrderDetail> getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(Set<OrderDetail> orderDetails) {
            this.orderDetails = orderDetails;
        }
*/
        public DelveryOrderAddress(String name, String city, String phnumber, String customeraddress) {
            this.name = name;
            this.city = city;
            this.phnumber = phnumber;
            this.customeraddress = customeraddress;
        }

        public DelveryOrderAddress(){}
        public Integer getId() {
            return id;
        }

        public String getCustomeraddress() {
            return customeraddress;
        }

        public void setCustomeraddress(String customeraddress) {
            this.customeraddress = customeraddress;
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
    }





