package com.example.Controllers;

import com.example.Domain.*;
import com.example.Helper.CountData;
import com.example.Helper.UserInfo;
import com.example.Services.*;
import com.example.message.Response;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waqas on 23/03/2017.
 */
@RestController
public class RestProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailservice orderDetailservice;

    @Autowired
    private UserServices userServices;

    @Autowired
    private RolesServices rolesServices;

    @Autowired
     org.springframework.core.env.Environment environment;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "productrest/{id}" , method = RequestMethod.GET)
    public @ResponseBody
        Product listAllUsers(@PathVariable int id) {
        Product products = productService.findById(id);
        return products;
    }
    @RequestMapping(value = "productrest" , method = RequestMethod.GET)
    public @ResponseBody List<Product> listAllProducts() {
        List<Product> product = productService.findAll();
        return product;
    }

    @RequestMapping(value = "user/allusers" , method = RequestMethod.GET)
    public @ResponseBody List<user> listAllUsers() {
        List<user> users = userServices.findAllUsers();
        return users;
    }
    @RequestMapping(value = "admin/allusers" , method = RequestMethod.GET)
    public @ResponseBody List<user> listAllUsersforadmin() {
        List<user> users = userServices.findAllUsers();
        return users;
    }
    @RequestMapping(value ="orderrest" , method = RequestMethod.GET)
    public @ResponseBody List<OrderDetail> orderrest() {
        List<OrderDetail> products =orderDetailservice.findAllOrdsers() ;
        return products;
    }
    @RequestMapping(value = "orderrest/{id}" , method = RequestMethod.GET)
    public @ResponseBody OrderDetail orderrestonebyone(@PathVariable int id) {
        OrderDetail products =orderDetailservice.findById(id) ;
        return products;
    }
    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    @ResponseBody public ResponseEntity<?> postForm(@RequestBody Product data) {
   System.err.println(data);

        return new ResponseEntity<String>("Offer Created", HttpStatus.OK);
    }

    @RequestMapping(value = "test/getallcustomer", method = RequestMethod.GET)
    public Response getResource() {
        List<Product> listofproduct = productService.findAll();
        Response response = new Response("Done", listofproduct);
        return response;
    }

    @RequestMapping(value = "test/postcustomer", method = RequestMethod.POST)
    public Response postCustomer(@RequestBody Product product) {
       //List<Product> cust = new ArrayList<Product>();
        //cust.add(customer);
        String p = product.getSelectedcategory();

        Category category  =  categoryService.findByName(p);

        if(category != null){
            product.setCategory(category);
        }
       productService.save(product);
        // Create Response Object
        Response response = new Response("Done", product);
        return response;
    }


    @RequestMapping(path = "/getusersdata", method = RequestMethod.GET)
    public ResponseEntity get_data_on_login() throws Exception {
        List<Roles> roles = rolesServices.allroles();
        List<user> users = userServices.findAllUsers();
        return new ResponseEntity( new UserInfo( users, roles ), HttpStatus.OK );
    }


    /*@RequestMapping(value = "productbynamerest/{name}")
    public List<Product> findByName(@PathVariable ("name") String name){

        return productService.findByName(name);

    }*/


}


