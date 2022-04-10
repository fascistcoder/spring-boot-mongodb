package com.example.springbootmongodb.commands;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
@Getter
@Setter
public class ProductForm {
	private String id;
	private String description;
	private BigDecimal price;
	private String imageUrl;
}
