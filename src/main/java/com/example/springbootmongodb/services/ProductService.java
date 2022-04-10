package com.example.springbootmongodb.services;

import com.example.springbootmongodb.commands.ProductForm;
import com.example.springbootmongodb.domain.Product;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
public interface ProductService {
	List<Product> listAll();

	Product getById(String id);

	Product saveOrUpdate(Product product);

	void delete(String id);

	Product saveOrUpdateProductForm(ProductForm productForm);
}
