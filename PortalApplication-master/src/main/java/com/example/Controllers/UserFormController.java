package com.example.Controllers;

import com.example.Domain.*;
import com.example.Helper.UserInfo;
import com.example.Helper.UserOrder;
import com.example.Repositories.UserFormBootstrapDAO;
import com.example.Services.OrderDetailservice;
import com.example.Services.RolesServices;
import com.example.Services.UserFormService;
import com.example.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    /*@RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String showGuestList() {
        userServices.findAllUsers();
        return "results :: resultsList";
    }*/


    @RequestMapping(value = "admin/users",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserInfo>>  getContacts() {
       List<Roles> roles = rolesServices.allroles();
        List<user> users = userServices.findAllUsers();
        //return new ResponseEntity( users , HttpStatus.OK );
        return new ResponseEntity (new UserInfo( users,roles) , HttpStatus.OK );
    }

    @RequestMapping(value="admin/userandroles", produces = {
            MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.GET)
    public String viewContacts () {
        return "contact-listing";
    }

//for customer and orders data
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

//Delete user


    @RequestMapping(value = "admin/delete/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userServices.DeleteUser(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}