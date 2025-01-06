package com.shopping.inventory.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {

	private List<Product> products;
	private Integer total;
	private Integer skip;
	private Integer limit;

}
