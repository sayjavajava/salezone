package com.example.Repositories;

import com.example.Domain.DelveryOrderAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamran on 8/18/2017.
 */
public interface AddressDAO extends CrudRepository<DelveryOrderAddress,Integer> {



}
