package com.example.springbootmongodb.converters;

import com.example.springbootmongodb.commands.ProductForm;
import com.example.springbootmongodb.domain.Product;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

	@Override
	public Product convert(ProductForm productForm) {
		Product product = new Product();
		if (productForm.getId() != null && StringUtils.hasText(productForm.getId())) {
			product.setId(new ObjectId(productForm.getId()));
		}
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		product.setImageUrl(productForm.getImageUrl());
		return product;
	}
}
