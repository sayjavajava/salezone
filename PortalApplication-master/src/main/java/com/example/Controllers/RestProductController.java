package com.example.Controllers;

import com.example.Domain.*;
import com.example.Services.CategoryService;
import com.example.message.Response;
import com.example.Services.OrderDetailservice;
import com.example.Services.ProductService;
import com.example.Services.UserServices;
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
    public @ResponseBody List<Product> listAllUsers() {
        List<Product> product = productService.findAll();
        return product;
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

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {

        try {
            // Get the filename and build the local file path (be sure that the
            // application have write permissions on such directory)
            String filename = uploadfile.getOriginalFilename();
            String directory = environment.getProperty("netgloo.paths.uploadedFiles");
            String filepath = Paths.get(directory, filename).toString();

            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}


