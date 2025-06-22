package com.shopping.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopping.order.model.Order;

public interface OrderRepository extends CrudRepository<Order, String>  {

}
