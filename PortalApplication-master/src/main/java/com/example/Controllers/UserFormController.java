package com.example.Controllers;

import com.example.Domain.*;
import com.example.Domain.UserForm;
import com.example.Helper.CountData;
import com.example.Helper.UserInfo;
import com.example.Helper.UserOrder;
import com.example.Repositories.UserFormBootstrapDAO;
import com.example.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by waqas on 28/02/2017.
 */
@Controller
public class UserFormController {

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private UserServices userServices;

    @Autowired
    private RolesServices rolesServices;

    @Autowired
    private OrderDetailservice orderDetailservice;

    @Autowired
    private ProductService productService;

    @Autowired
    private Contactservices contactservices;

    @Autowired
    private AndroidAddressServices androidAddressServices;

    @RequestMapping("userform/new")
    public String saverecord(Model model){
        model.addAttribute("UserForm",new UserForm());
        return "userformbootstrap";
    }
    @RequestMapping("/search")
    public String searchAjax(){
        return "search";
    }

    @RequestMapping("admin/addroles")
    public String addroles(Roles roles){
     rolesServices.saveRoles(roles);
     return "allusers";
    }

    @RequestMapping("/formact")
    public String saverecord(UserForm product){
        List<UserForm> foundlist =userFormService.findByEmail(product.getEmail());

        userFormService.save(product);
                  //userFormService.save(product);
        return "userform/new";
    }


    @RequestMapping("/contactsave")
    public String ContactSave(@Valid Contact contact, BindingResult bindingResult){

ModelAndView modelAndView = new ModelAndView();
if (bindingResult.hasErrors()){
    modelAndView.setViewName("cloth/mail");
}

        contactservices.saveContact(contact);
        modelAndView.addObject("successMessage", "Message Has Been sent");
        return "cloth/clothhome";
    }


    @RequestMapping("/mail")
    public String mail(Model model)
    {
        model.addAttribute("contactmail", new Contact());
        return "cloth/mail" ;
    }
    @RequestMapping("/admin/messages")
    public String AllMessages(Model model)
    {
        List<Contact> listmessage = new ArrayList<Contact>();

      Iterable <Contact> allmessages = contactservices.allmessages();

      allmessages.forEach(listmessage ::add);

      model.addAttribute("contactmail", listmessage);

        return "messages" ;
    }

    @RequestMapping("/admin/orderpalaced")
    public String Allandroidaddress(Model model)
    {
        List<AndroidAddress> listmessage = new ArrayList<AndroidAddress>();

        Iterable <AndroidAddress> allmessages =androidAddressServices.allandroidaddress() ;

        allmessages.forEach(listmessage ::add);

        model.addAttribute("contactmail", listmessage);

        return "androidmessages" ;
    }


    @RequestMapping(value = "/guests/{surname}", method = RequestMethod.GET)
    public String showGuestList(Model model, @PathVariable("surname") String surname) {
        model.addAttribute("guests",userFormService.findByLastName(surname));

        return "results :: resultsList";
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("guests", userFormService.AllGuests());

        return "results :: resultsList";
    }


    @RequestMapping(value = "admin/users",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserInfo>>  getContacts() {
       List<Roles> roles = rolesServices.allroles();
        List<user> users = userServices.findAllUsers();
        return new ResponseEntity (new UserInfo( users,roles) , HttpStatus.OK );
    }

    @RequestMapping(value="admin/userandroles", produces = {
            MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.GET)
    public String viewContacts () {
        return "contact-listing";
    }


@RequestMapping(value = "admin/customers",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<List<OrderDetail>>  getCustomers() {
    List<OrderDetail> orderDetails =orderDetailservice.findAllOrdsers();
    List<user> users = userServices.findAllUsers();
    //return new ResponseEntity( users , HttpStatus.OK );
//    return new ResponseEntity (new UserOrder(orderDetails,users) , HttpStatus.OK );
    return new ResponseEntity <List<OrderDetail>> (orderDetails, HttpStatus.OK );
    }

    @RequestMapping(value="admin/customerorders", produces = {
            MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.GET)
    public String customerorders () {
        return "customerordered";
    }



//Delete orders


    @RequestMapping(value = "delete/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePartyn(@PathVariable int id) {
        orderDetailservice.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping(value = "admin/delete/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userServices.DeleteUser(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    //Count All Entities
    @RequestMapping("/admin/graph")
    public String graph(Model model)
    {
        model.addAttribute("countuser",userServices.countAllUsers());

        model.addAttribute("countproducts",productService.countallproducts());

        model.addAttribute("countorders",orderDetailservice.countallorders());

        return "GraphPage" ;
    }



    @RequestMapping(value = "/customerhistory",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OrderDetail>>  getAccountData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user user = userServices.findByEmail(auth.getName());
        int id = user.getId();
       System.err.println("current user "+id);
        List<OrderDetail> orderDetails =orderDetailservice.findByPurchasedBy(id);

        return new ResponseEntity <List<OrderDetail>> (orderDetails, HttpStatus.OK );
    }

    @RequestMapping(value = "customeraccount/{id}" , method = RequestMethod.GET)
    public @ResponseBody List<OrderDetail> orderrestonebyone(@PathVariable int id) {
        List<OrderDetail> products =orderDetailservice.findByPurchasedBy(id) ;
        return products;
    }

    @RequestMapping("/customeraccounthistory")
    public String searchonmale(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user user = userServices.findByEmail(auth.getName());
        int id = user.getId();
        System.err.println("current user "+id);
        List<OrderDetail> orderDetails =orderDetailservice.findByPurchasedBy(id);
model.addAttribute("history",orderDetails);
        return "customerhistory";
    }
    //edit admin/user/edit/{id}
}