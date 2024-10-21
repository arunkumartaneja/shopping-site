package com.shopping.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public String getOrders() {
		return orderService.findAll();
	}
}
