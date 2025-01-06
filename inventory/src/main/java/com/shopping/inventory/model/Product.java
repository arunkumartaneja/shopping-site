package com.shopping.inventory.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private String id;
	private String title;
	private String description;
	private String category;
	private String price;
	private String discountPercentage;
	private String rating;
	private String brand;
	private String stock;
	private String[] images;
	private String thumbnail;

}
