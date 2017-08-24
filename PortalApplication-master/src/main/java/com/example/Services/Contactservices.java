package com.example.Services;

import com.example.Domain.Contact;
import com.example.Repositories.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamran on 8/23/2017.
 */


@Service
public class Contactservices {


private ContactDAO contactDAO;
    @Autowired
   public Contactservices(ContactDAO contactDAO){
this.contactDAO = contactDAO;
    }

    public void saveContact(Contact contact){

       contactDAO.save(contact);
    }

    public Iterable<Contact> allmessages(){

        Iterable<Contact> messages = contactDAO.findAll();

        return  contactDAO.findAll();
    }
}
