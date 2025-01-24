package com.shopping.inventory.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory implements Serializable {

	private static final long serialVersionUID = 3186836634025440782L;

	private List<Product> products;
	private Integer total;
	private Integer skip;
	private Integer limit;

}
