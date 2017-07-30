package com.example.Helper;

import com.example.Domain.OrderDetail;
import com.example.Domain.user;

import java.util.List;

/**
 * Created by kamran on 7/27/2017.
 */
public class UserOrder {

    private List<user> userList;
    private List<OrderDetail> orderList;

    public UserOrder( List<OrderDetail> orderList,List<user>userList) {
        this.userList = userList;
        this.orderList = orderList;
    }

    public List<user> getUserList() {
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

    public List<OrderDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }
}
