package com.example.Domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Product implements Serializable {
/*@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;*/


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Product name must not be null")
    private String name;

    private String description;
    @NotEmpty(message = "Image source can not be null")
    private String imageUrl;


    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


/*

    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderDetail orderDetail;
*/



    @ManyToMany(cascade = CascadeType.ALL)
/*
    @JoinTable(
            name = "book_author",
            joinColumns = { @JoinColumn(name = "fk_p_id") },
            inverseJoinColumns = { @JoinColumn(name = "fk_od_id") })
*/
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    @Transient
    private String categorychosen;

    public String getCategorychosen() {
        return categorychosen;
    }

    public void setCategorychosen(String categorychosen) {
        this.categorychosen = categorychosen;
    }




    @Transient
    private String selectedcategory;

    @Transient
    public String getSelectedcategory() {
        return selectedcategory;
    }

    public void setSelectedcategory(String selectedcategory) {
        this.selectedcategory = selectedcategory;
    }

  /*  public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
*/

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(){}
    public Product(String name, String description, String imageUrl, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
    public Product(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
