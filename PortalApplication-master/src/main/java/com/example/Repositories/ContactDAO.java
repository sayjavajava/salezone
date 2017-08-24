package com.example.Repositories;

import com.example.Domain.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamran on 8/23/2017.
 */
public interface ContactDAO extends CrudRepository<Contact,Integer> {


}
