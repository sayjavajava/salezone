package com.example.Services;

import com.example.Domain.*;
import com.example.Domain.Product;
import com.example.Repositories.OrderDetailDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by waqas on 13/03/2017.
 */
@Service
public class OrderDetailservice {

    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    private Cart cart;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String palaceorder(Map<Product,Integer> allcollection, user userid,DelveryOrderAddress delveryOrderAddress){
    OrderDetail orderDetaildomain = new OrderDetail();
    orderDetaildomain.setDevaddressorder(delveryOrderAddress.getCustomeraddress());
    orderDetaildomain.setPhnumber(delveryOrderAddress.getPhnumber());
    System.err.println(delveryOrderAddress.getCity());
    Date now = new Date();
        orderDetaildomain.setId(300);
        if(allcollection.size() != 0) {
         for (Map.Entry<Product, Integer> entry : allcollection.entrySet()) {

        orderDetaildomain.setQuantity(cart.getCartSize());
        //orderDetaildomain.setProduct(entry.getKey());
        orderDetaildomain.setPrice(((int) cart.getTotalCost()));
        orderDetaildomain.setUser(userid);
       // orderDetaildomain.setAddress(delveryOrderAddress);
        orderDetaildomain.setDate(now);

        // System.err.println("items"+orderDetaildomain.getProduct().getId());
        // orderitem.setProduct(entry.getKey());
        // orderDetaildomain.setOrderitem(orderitem);
        //orderDetaildomain.getProductlist().add(entry.getKey());
        orderDetaildomain.getProductlist().add(entry.getKey());

        //orderDetailDAO.save(orderDetaildomain);
        //orderItemDAO.save(orderitem);

    }
for(Product od : orderDetaildomain.getProductlist()){

        logger.info(od.getId()+od.getName());
}
    orderDetaildomain.setStatus("In progress");
    orderDetailDAO.save(orderDetaildomain);
}
        return null;
}
public Page<OrderDetail> findAll(Pageable pageable){
    return orderDetailDAO.findAll(pageable);
}


public List<OrderDetail> findAllOrdsers(){

    return orderDetailDAO.findAll();
}
    public String delete(int id){


        orderDetailDAO.delete(id);
        return "order deleted ";
    }

public OrderDetail findById(int id){
    OrderDetail orderDetail = orderDetailDAO.findOne(id);
return orderDetail;
}

    public List<OrderDetail> findByProductId(int id){
         return orderDetailDAO.findByProductlistId(id);
    }
/*public List<OrderDetail> findAllCustomers(){
return ;
}*/

public void DeleteOrder(int id){

    orderDetailDAO.delete(id);
}
public Long countallorders(){
    return orderDetailDAO.count();
}


    public List<OrderDetail> findByPurchasedBy(int id){

        return orderDetailDAO.findByPurchasedBy(id);
    }


}
