package com.shopping.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.inventory.model.Product;
import com.shopping.inventory.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product products) {
		return productRepository.save(products);
	}

	public List<Product> saveAll(List<Product> products) {
		return productRepository.saveAll(products);
	}

}
