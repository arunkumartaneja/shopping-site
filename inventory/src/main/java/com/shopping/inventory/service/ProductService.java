package com.shopping.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.inventory.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product products) {
		return productRepository.save(products);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

}
