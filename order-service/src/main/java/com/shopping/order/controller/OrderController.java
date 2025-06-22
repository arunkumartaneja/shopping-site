package com.shopping.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order.model.Order;
import com.shopping.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Order> getOrders() {
		logger.info("OrderController --> getOrders ");
		return orderService.findAll();
	}

	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable String orderId) {
		logger.info("OrderController --> getOrder ", orderId);
		return orderService.findById(orderId);
	}

	@GetMapping("/place")
	public String placeOrder(@RequestParam int quantity) {
		return orderService.placeOrder(quantity);
	}
}
