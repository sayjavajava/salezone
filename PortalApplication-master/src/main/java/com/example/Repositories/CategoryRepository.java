package com.example.Repositories;

import com.example.Domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by waqas on 30/03/2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findByName(String name);
}
