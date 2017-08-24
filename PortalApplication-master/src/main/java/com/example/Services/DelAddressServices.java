package com.example.Services;

import com.example.Domain.DelveryOrderAddress;
import com.example.Repositories.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamran on 8/19/2017.
 */
@Service
public class DelAddressServices {

    @Autowired
    private AddressDAO addressDAO;




    public void  saveaddressorder(DelveryOrderAddress address){
        addressDAO.save(address);

    }

}
