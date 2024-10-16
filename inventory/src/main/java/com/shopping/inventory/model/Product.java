package com.shopping.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "products")
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private String category;
	private String price;
	private String discountedPrice;
	private String image;
	private String brand;
	private String specifications;

}
