package com.shopping.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping
	public String getOrders() {
		logger.info("OrderController --> getOrders ");
		return orderService.findAll();
	}

	@GetMapping("/place")
	public String placeOrder(@RequestParam int quantity) {
		return orderService.placeOrder(quantity);
	}
}
