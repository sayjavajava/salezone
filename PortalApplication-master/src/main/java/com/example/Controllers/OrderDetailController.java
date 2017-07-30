package com.example.Controllers;

import com.example.Domain.OrderDetail;
import com.example.Repositories.OrderDetailDAO;
import com.example.Services.OrderDetailservice;
import com.example.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by waqas on 16/03/2017.
 */
@Controller
public class OrderDetailController {

    @Autowired
    private OrderDetailservice orderDetailservice;


    @Autowired
    private UserServices userServices;
    @RequestMapping(value = "order/orderlist", method = RequestMethod.GET)
    Page<OrderDetail> orderslist(Pageable pageable) {
        return orderDetailservice.findAll(pageable);
    }

    //@RequestMapping(value = "order/allorders", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("orderlist", orderDetailservice.findAllOrdsers());
        return "User/orderresults :: orderlist";
    }

    @RequestMapping(value = "/frag1", method = RequestMethod.GET)
    public String frag1(Model model) {
        model.addAttribute("content", "hello");
        return "User/fragment1 ::content";
    }

    //testing for custom queries
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping(value = "order/allordersdata")
     public String showorders(Model model){
        model.addAttribute("orderslist",orderDetailservice.findAllOrdsers());
        return "order/allorders";
    }
    @RequestMapping(value = "/order/edit/id")
    public String editstatus(@PathVariable int id,Model model){
    model.addAttribute("orderlist",orderDetailservice.findById(id));
        return "order/editorder";
    }


    @RequestMapping("admin/delete/order/{id}")
    public String delete(@PathVariable int id){
        orderDetailservice.delete(id);
        return "redirect:/products";
    }

}