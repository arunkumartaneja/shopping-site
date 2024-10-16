package com.shopping.inventory.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shopping.inventory.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{name:'?0'}")
	Product findItemByName(String name);

	@Query(value = "{category:'?0'}", fields = "{'name' : 1, 'description' : 1}")
	List<Product> findAll(String category);

	public long count();
}
