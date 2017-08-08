package com.example.Services;

import com.example.Domain.OrderDetail;
import com.example.Domain.Product;
import com.example.Repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by waqas on 24/02/2017.
 */
@Service
@Transactional
public class ProductService  {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    private OrderDetailservice orderDetailservice;


    public List<Product> findAll(){
    List<Product> list =  productDAO.findAll();
    return list;}

    public String save(Product product){
      // product.setOrderDetail(null);
       // product.setImageUrl(product.getImageUrl()+"."+"jpg");
        productDAO.save(product);
        return "task-saved";
    }
    public String delete(int id){

if(id !=0)

       productDAO.delete(id);

        return "task-deleted";
    }

    public Product findById(int id){
    Product list = productDAO.findOne(id);
    return list;
    }

    public  List<Product> findByCategory(String name){
     List<Product> productList= productDAO.findProductByCategoryName(name);
    return productList;
    }

    public Long countallproducts(){

        return productDAO.count();
    }
    public List<Product> findByName(String name){
        return productDAO.findProductByName(name);
    }

    public Product findBySingleName(String name){
        Product list = productDAO.findByName(name);
        return list;
    }
}


