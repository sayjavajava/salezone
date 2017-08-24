package com.example.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

/**
 * Created by waqas on 13/03/2017.
 */
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name="purchased_By")
    private user PurchasedBy;



    @ManyToMany
    @JoinTable(name = "order_product_final", joinColumns = { @JoinColumn(name = "order_detail_id") }, inverseJoinColumns = { @JoinColumn(name = "productlist_id") })
    private Set<Product> productlist = new HashSet<Product>();




    public Set<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(Set<Product> productlist) {
        this.productlist = productlist;
    }
    public user getPurchasedBy() {
        return PurchasedBy;
    }

    public void setPurchasedBy(user purchasedBy) {
        PurchasedBy = purchasedBy;
    }

    private Integer quantity;

    private Integer price;

    @Temporal(TemporalType.DATE)
    private Date date;



    @Column(name = "DeleveryAddress")
    private String devaddressorder;



    @Column(name = "PhNumber")
    private String phnumber;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public OrderDetail(){}

    public OrderDetail(Product product, user purchasedBy, Integer quantity, Integer price, Date date) {
        //this.product = product;
        PurchasedBy = purchasedBy;
        this.quantity = quantity;
        this.price = price;
        this.date = date;

    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getDevaddressorder() {
        return devaddressorder;
    }

    public void setDevaddressorder(String devaddressorder) {
        this.devaddressorder = devaddressorder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.Domain.user getUser() {
        return PurchasedBy;
    }

    public void setUser(com.example.Domain.user user) {
        this.PurchasedBy = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
