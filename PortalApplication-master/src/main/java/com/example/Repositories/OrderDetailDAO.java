package com.example.Repositories;

import com.example.Domain.OrderDetail;
import com.example.Domain.Product;
import com.example.Domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by waqas on 13/03/2017.
 */
@Repository
public interface OrderDetailDAO extends PagingAndSortingRepository<OrderDetail,Integer>,JpaRepository<OrderDetail,Integer> {
/*
    final static String product_ordered = "select p from OrderDetail p inner join order_detail_productlist ur on(p.id=ur.order_detail_id) where p.id= :id ";

    @Query(product_ordered)
    public List<OrderDetail> findById(@Param("id") int id);*/
List<OrderDetail> findAll();

List<OrderDetail> findByProductlistId(int id);


}
