package com.example.Controllers;

import com.example.Domain.*;

import com.example.Services.*;
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
import java.util.List;

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
    private NotificationService notificationService;

    @Autowired
    private OrderDetailservice orderDetailservice;
    StringBuilder mod;

    @Autowired
   private DelAddressServices deleveryAddress;

    @Autowired
    private CategoryService categoryService;

//   @Autowired
//   public ProductController (addressservices addressservice){
//       this.addressservice = addressservice;
//   }
    private OrderDetail orderDetail;

   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/admin/test")
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


    @RequestMapping("/clothhome")
    public String testgraph(Model model)
    {
        //model.addAttribute("product",new Product());

        List<Product> productslist = productService.findAll();
        model.addAttribute("products", productslist);
        return "cloth/clothhome" ;
    }

    @RequestMapping("/dresses")
    public String dresses(Model model)
    {
        //model.addAttribute("product",new Product());

        return "cloth/dresses" ;
    }

    @RequestMapping("/about")
    public String about(Model model)
    {
        //model.addAttribute("product",new Product());

        return "cloth/about" ;
    }
    @RequestMapping("/clothproducts")
    public String clothproduct()
    {
        //model.addAttribute("product",new Product());

        return "cloth/clothproducts" ;
    }
    @RequestMapping("/checkout")
    public String checkout(Model model)
    {
        model.addAttribute(cart);
        return "checkout" ;
    }
    @RequestMapping("/faq")
    public String faq()
    {
        return "cloth/faq" ;
    }
    @RequestMapping("/shirts")
    public String shirt()
    {
        return "cloth/shirts" ;
    }
    @RequestMapping("/jeans")
    public String jeans()
    {
        return "cloth/jeans" ;
    }
    @RequestMapping("/sarees")
    public String sarees()
    {return "cloth/sarees" ;}
    @RequestMapping("/single")
    public String single()
    {return "cloth/single" ;}
    @RequestMapping("/sandals")
    public String sandals()
    {return "cloth/sandals" ;}
    @RequestMapping("/skirts")
    public String skirts(Model model)
    {

        List<Product> productslist = productService.findAll();
        model.addAttribute("products", productslist);
        return "cloth/skirts" ;}
    @RequestMapping("/salwars")
    public String salwars()
    {return "cloth/salwars" ;}
    @RequestMapping("/femaledressingroom")
    public String tryme()
    {return "cloth/tryme" ;}

    @RequestMapping("/maledressingroom")
    public String maleroom()
    {return "cloth/maleroom" ;}



    @RequestMapping(value ={ "/admin/products","/admin/product"})
    public String list(Model model){
         List<Product> productslist = productService.findAll();
         model.addAttribute("products", productslist);
        return "products";
    }


    @RequestMapping(value = "product/{id}")
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "productshow";
    }

    @RequestMapping(value = "productbyname/{name}")
    public String findByName(@PathVariable ("name") String name, Model model){
        model.addAttribute("productname",productService.findByName(name));
        return "cloth/clothhome";
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

        String categorychosen = product.getCategorychosen();

        System.err.println("category_is: " + categorychosen);

        Category categoryfinal = categoryService.findByName(categorychosen);

        product.setCategory(categoryfinal);

        if(bindingResult.hasErrors()){
            return "admin/addproduct";
        }

        productService.save(product);
        return "redirect:/product/" +product.getId();
    }


    @RequestMapping("/productGender/{name}")
    public String searchonmale(@PathVariable String name,Model model){
        List<Product> maleCategory= productService.findOnMaleCategory(name);
        for(Product p : maleCategory){
            System.err.println("name:" +p.getName());
        }
        model.addAttribute("genderlist",maleCategory);
        return "ClothMaleCategory";
    }

    @RequestMapping("/saveadress")
    public String saveadressform(@Valid DelveryOrderAddress address , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "orderaddress";
        }
        deleveryAddress.saveaddressorder(address);
        //productService.save(product);
        return "cloth/clothhome";
    }

//delete item from db
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable int id){
    productService.delete(id);
    return "redirect:/admin/products";
}

//adding to cart
@RequestMapping("/product/cart/{productid}")
public String AddProduct(@PathVariable("productid") Integer productid,@RequestHeader("referer") String refredfrom ,RedirectAttributes redirectAttributes){
    Product product = productService.findById(productid);
    if(product != null){
    cart.addProduct(product);
//redirectAttributes.addFlashAttribute("cartinfo","item has been added");
    }
    return "redirect:"+refredfrom;
}

    @RequestMapping(value = "/product/cart/test/{productname}")
    public String findbyname(@PathVariable("productname") String productname,@RequestHeader("referer") String refredfrom ){
        Product product = productService.findBySingleName(productname);

//cart.cartadd(product);
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
@RequestMapping("product/custominfo")
public String orderaddress(Model model){
model.addAttribute("addressdev", new DelveryOrderAddress());
     return "orderaddress";
}


 @RequestMapping("/product/palaceorder")
 public ModelAndView palaceorder(@Valid DelveryOrderAddress address , BindingResult bindingResult, HttpSession session , RedirectAttributes redirectAttributes){
     ModelAndView modelAndView = new ModelAndView();
     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     user user = userService.findByEmail(auth.getName());

//      modelAndView.setViewName("redirect:/checkout");
  modelAndView.setViewName("redirect:/product/custominfo");
      int loggedinuser = user.getId();
      System.err.println("user logged "+loggedinuser);
      if(cart.getCartSize() !=0) {
         redirectAttributes.addAttribute("message" + user.getEmail() + cart.getContents().entrySet());
         //logger.info("waqas"+user.getEmail());
         if(user != null) {

             if(bindingResult.hasErrors()){
                 redirectAttributes.addFlashAttribute("formerror","please fill your form properly");
                 return modelAndView;
             }
             deleveryAddress.saveaddressorder(address);
             orderDetail = new OrderDetail();

           /*  orderDetail.setAddress(address);
             logger.info("guy"+orderDetail.getAddress().getCustomeraddress());
*/
             orderDetailservice.palaceorder(cart.getContents(),user,address);
             try {
                 notificationService.sendOrderMail(user,orderDetail);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             redirectAttributes.addFlashAttribute("orderstatus", "order has been  palaced");
         } else{ redirectAttributes.addFlashAttribute("orderstatus","Please Log in First");}
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

         final String uploadDir = System.getProperty("netgloo.paths.uploadedFiles") ;


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
    //edit admin/user/edit/{id}
}
