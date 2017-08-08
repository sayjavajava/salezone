package com.example.Repositories;

import com.example.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by waqas on 24/02/2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer>  {
/*
    public final static String product_ordered ="select r.name from OrderDetail u inner join order_detail_productlist ur " +
            "on(u.id=ur.order_detail_id) inner join Product r" +
            " on(ur.productlist_id=r.id)" +
            " where u.id= :id ";

    @Query(product_ordered)
    public List<Product> findById(@Param("id") int id);*/


List<Product> findProductByCategoryName(String name);

    List<Product> findProductByName(String name);

Product findByName(String name);
}
