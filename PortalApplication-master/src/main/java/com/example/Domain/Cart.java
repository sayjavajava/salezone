 package com.example.Domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.*;


 /**
 * Created by waqas on 11/03/2017.
 */

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value = WebApplicationContext.SCOPE_SESSION)
public class Cart {

     private final Logger logger = LoggerFactory.getLogger(this.getClass());

     private Map<Product ,Integer> contents = new HashMap<Product,Integer>();

private List<Product> cartlist = new ArrayList<>();

public void cartadd(Product product){

      cartlist.add(product);

      for (Product p :cartlist) {
          logger.info(p.getName());
          System.err.println(p.getId());
          logger.info(p.getDescription());
      }
      }

     public Map<Product, Integer> getContents() {
         return contents;
     }

     public Set<Product> getProduct(){
      return contents.keySet();
}

     public void addProduct(Product product){
         //int count =contents.containsKey(product.getId()) ?contents.get(product.getId()):0;

      Integer   count = contents.get(product);
         //logger.info(count.toString());

         logger.info("value of cart" +" " +count +" "+"id"+ product.getId());

         if(contents.containsKey(product.getId())){
             contents.put(product,contents.get(product)+1);

             logger.info("i am  existing");
       }else {
             logger.info("i am new one ");
             contents.put(product,1);
//             System.err.println("product-cart"+product.getName() + product.getId()+product.getImageUrl()+product.getDescription()+product.getPrice()+product.getCategory());

             }
       //contents.computeIfPresent(product,(k,v)->v+1);
    System.err.println("product-contains"+testkey(product));

}
private boolean testkey(Object object){
         return this.contents.containsKey(object);
}


    public  void remove(Product p ){

        for(Iterator<Map.Entry<Product,Integer>>it=contents.entrySet().iterator();it.hasNext();){
            Map.Entry<Product, Integer> entry = it.next();
            if (entry.getKey().getId().equals(p.getId()) ) {
                it.remove();
            }
        }
    }

    public void clearall(){contents.clear();}
    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + contents +
                '}';
    }
    public double getTotalCost() {
        double grandtotal = 0;
        for (Product product : contents.keySet()) {
            grandtotal += product.getPrice().doubleValue();
        }
        return grandtotal;
    }

     public int getCartSize(){

         int sizelist = 0;
         sizelist = contents.size();
       //  System.err.println("list-size"+sizelist);
         return sizelist;
     }
}
