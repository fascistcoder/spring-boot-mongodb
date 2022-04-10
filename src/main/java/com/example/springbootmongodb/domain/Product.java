package com.example.springbootmongodb.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
@Getter
@Setter
@Document
public class Product {

	@Id
	private ObjectId id;

	private String description;

	private BigDecimal price;

	private String imageUrl;
}
