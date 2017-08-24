package com.example.Services;

import com.example.Domain.AndroidAddress;
import com.example.Repositories.AndroidAddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamran on 8/24/2017.
 */
@Service
public class AndroidAddressServices {

    @Autowired
    private AndroidAddressDAO androidAddressDAO;


    public Iterable<AndroidAddress> allandroidaddress(){

       Iterable<AndroidAddress> alldata = androidAddressDAO.findAll();

       return alldata;
    }
}
