package com.example.Controllers;

import com.example.Domain.Cart;
import com.example.Domain.Product;
import com.example.Domain.user;
import com.example.Services.OrderDetailservice;
import com.example.Services.ProductService;
import com.example.Services.UserServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by waqas on 24/02/2017.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    private Environment environment;

    @Autowired
    private UserServices userService;
    @Autowired
    private Cart cart;
    @Autowired
    private OrderDetailservice orderDetailservice;
    StringBuilder mod;
//    private static final  Logger LOGGER =  LoggerFactory.getLogger(ProductController.class);
private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
     public String test(Model model)
    {
      //model.addAttribute("product",new Product());
        return "admin/addproductviaajax" ;
    }

    @RequestMapping("/addproductviaajax")
    public String addProductViaAjax(Model model)
    {
        //model.addAttribute("product",new Product());
        return "admin/addproductviaajax" ;
    }

    @RequestMapping(value = "/products")
    public String list(Model model){
         List<Product> productslist = productService.findAll();
         model.addAttribute("products", productslist);
        return "products";
    }

    @RequestMapping(value = "/product/{id}")
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "productshow";
    }
    @Async
    @RequestMapping("product/new")
    public String saverecord(Model model){
        model.addAttribute("product",new Product());
        return "admin/addproduct";
    }
    @RequestMapping("product/edit/{id}")
    public String editecord(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "admin/addproduct";
    }

    @Async
    @RequestMapping("/productact")
    public String saverecord(@Valid Product product , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/addproduct";
        }
     //   product.setImageUrl(product.getImageUrl()+"."+"jpg");
      //  product.setProduct_uid(product.getId());

        productService.save(product);
        return "redirect:/product/" +product.getId();
    }
//delete item from db
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable int id){
    productService.delete(id);
    return "redirect:/products";
}

//adding to cart
@RequestMapping("/product/cart/{productid}")
public String AddProduct(@PathVariable("productid") Integer productid,@RequestHeader("referer") String refredfrom ){
    Product product = productService.findById(productid);
    cart.addProduct(product);
    return "redirect:"+refredfrom;
}
//delete cart
@RequestMapping("/product/deletecart/{productid}")
public String DeleteProduct(@PathVariable("productid") Integer productid,@RequestHeader("referer") String refredfrom ){
   Product product = productService.findById(productid);
    logger.info("delete id is"+productid);
    cart.remove(product);
    return "redirect:"+refredfrom;
}
//show cart
 @RequestMapping("product/cart")
 public String showcart(Model model){
 model.addAttribute(cart);
     return "cart";
 }

 //show ajax


 @RequestMapping("/product/palaceorder")
 public ModelAndView palaceorder(HttpSession session , RedirectAttributes redirectAttributes){
     ModelAndView modelAndView = new ModelAndView();
     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     user user = userService.findByEmail(auth.getName());
     modelAndView.setViewName("redirect:/product/cart");
      int loggedinuser = user.getId();
      System.err.println("user logged "+loggedinuser);
     if(cart.getCartSize() !=0) {
         redirectAttributes.addAttribute("message" + user.getEmail() + cart.getContents().entrySet());
         //logger.info("waqas"+user.getEmail());
         orderDetailservice.palaceorder(cart.getContents(), user);
         redirectAttributes.addFlashAttribute("orderstatus","order has been  palaced");
         return modelAndView;
     }
     redirectAttributes.addFlashAttribute("orderstatus","Please add items to cart");
   return modelAndView;
 }
@RequestMapping("/loadfile")
public String loadFile(){
    return "upload";
}

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {

        try {

            String filename = uploadfile.getOriginalFilename();
            String directory = environment.getProperty("netgloo.paths.uploadedFiles");

            String filepath = Paths.get(directory, filename).toString();

            // Save the file
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
