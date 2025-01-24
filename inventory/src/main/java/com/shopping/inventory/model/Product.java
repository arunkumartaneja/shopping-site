package com.shopping.inventory.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product implements Serializable {

	private static final long serialVersionUID = 1500333661782910889L;

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
