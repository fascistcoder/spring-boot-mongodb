package com.example.springbootmongodb.repositories;

import com.example.springbootmongodb.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
public interface ProductRepository extends CrudRepository<Product, String> {
}
