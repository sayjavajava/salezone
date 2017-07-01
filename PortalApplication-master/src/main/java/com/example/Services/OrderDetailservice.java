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

    public String palaceorder(Map<Product,Integer> allcollection, user userid){
    OrderDetail orderDetaildomain = new OrderDetail();
    Date now = new Date();
        orderDetaildomain.setId(300);
if(allcollection.size() != 0) {
    for (Map.Entry<Product, Integer> entry : allcollection.entrySet()) {

        orderDetaildomain.setQuantity(cart.getCartSize());
        //orderDetaildomain.setProduct(entry.getKey());
        orderDetaildomain.setPrice(((int) cart.getTotalCost()));
        orderDetaildomain.setUser(userid);
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
    orderDetaildomain.setStatus("Non delivered");
    orderDetailDAO.save(orderDetaildomain);
}
        return null;
}
public Page<OrderDetail> findAll(Pageable pageable){
    return orderDetailDAO.findAll(pageable);
}
public List<OrderDetail> findAllOrdsers(){
  //  List<OrderDetail> testlist = orderDetailDAO.findAll();

/*    for(OrderDetail orderDetail:testlist) {
       // System.err.println("size " + orderDetail.getUser());
        for (Product p : orderDetail.getProductlist()) {
            System.err.println(p.getId());
            System.err.println(p.getName());
        }
}*/
    return orderDetailDAO.findAll();
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

}
