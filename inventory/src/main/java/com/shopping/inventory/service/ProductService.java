package com.shopping.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.inventory.model.Inventory;
import com.shopping.inventory.model.Product;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private RestTemplate restTemplate;

	private final String url = "https://dummyjson.com/products";

	public Inventory findAll() {
		logger.info("getting products list from {}", url);
		ResponseEntity<Inventory> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Inventory>() {
				});

		Inventory inventory = response.getBody();

		return inventory;
	}

	public String save(Product products) {
		return "product saved";
	}

	public List<Product> saveAll(List<Product> products) {
		return new ArrayList<>();
	}

	public int getAvailableQuantity(String productId) {
		// Mock inventory data
		return 100; // Assume 100 units are available for any product
	}

}
