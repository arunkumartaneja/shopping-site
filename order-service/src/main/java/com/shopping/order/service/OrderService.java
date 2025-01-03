package com.shopping.order.service;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.order.repository.InventoryClient;
import com.shopping.order.repository.PaymentClient;

@Service
public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private InventoryClient inventoryClient;

	@Autowired
	private PaymentClient paymentClient;

	public String placeOrder(int quantity) {
		String productId = UUID.randomUUID().toString();

		boolean available = isProductAvailable(productId, quantity);

		if (available) {
			logger.info("product available time: {}, productid: {}, quantity: {}", new Date().toString(), productId,
					quantity);

			String orderId = UUID.randomUUID().toString();

			String response = paymentClient.pay(orderId);

			return "Order placed successfully response: " + response;
		} else {
			logger.info("Product is not available in the required quantity");
			return "Product is not available in the required quantity.";
		}
	}

	public String findAll() {
		logger.info("OrderService --> findAll ");
		return "test " + new Date().toString();
	}

	public boolean isProductAvailable(String productId, int quantity) {
		return inventoryClient.checkProductAvailability(productId, quantity);
	}

}
