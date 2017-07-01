package com.example.Services;

import com.example.Domain.Category;
import com.example.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by waqas on 30/03/2017.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category findByName(String name){
      return  categoryRepository.findByName(name);
}
}
