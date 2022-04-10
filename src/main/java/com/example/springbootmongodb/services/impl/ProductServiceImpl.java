package com.example.springbootmongodb.services.impl;

import com.example.springbootmongodb.commands.ProductForm;
import com.example.springbootmongodb.converters.ProductFormToProduct;
import com.example.springbootmongodb.domain.Product;
import com.example.springbootmongodb.repositories.ProductRepository;
import com.example.springbootmongodb.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private ProductFormToProduct productFormToProduct;

	@Override public List<Product> listAll() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products :: add);
		return products;
	}

	@Override public Product getById(String id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override public Product saveOrUpdate(Product product) {
		return productRepository.save(product);
	}

	@Override public void delete(String id) {
		productRepository.deleteById(id);
	}

	@Override public Product saveOrUpdateProductForm(ProductForm productForm) {
		Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

		System.out.println("Saved Product Id: " + savedProduct.getId());
		return savedProduct;
	}
}
