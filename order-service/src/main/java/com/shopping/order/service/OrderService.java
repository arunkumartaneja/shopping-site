package com.shopping.order.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.order.model.Order;
import com.shopping.order.repository.InventoryClient;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.repository.PaymentClient;

@Service
public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private InventoryClient inventoryClient;

	@Autowired
	private PaymentClient paymentClient;

	@Autowired
	private OrderRepository orderRepository;

	public String placeOrder(int quantity) {
		String productId = UUID.randomUUID().toString();

		boolean available = isProductAvailable(productId, quantity);

		if (available) {
			logger.info("product available time: {}, productid: {}, quantity: {}", new Date().toString(), productId,
					quantity);

			String orderId = UUID.randomUUID().toString();

			String paymentId = paymentClient.pay(orderId, productId);
			String msg = "payment seccussfull for order: " + orderId + " and transection id: " + paymentId;
			Order order = new Order(orderId, quantity, paymentId, productId);
			orderRepository.save(order);

			return "Order placed successfully response: " + msg;
		} else {
			logger.info("Product is not available in the required quantity");
			return "Product is not available in the required quantity.";
		}
	}

	public List<Order> findAll() {
		logger.info("OrderService --> findAll ");
		return (List<Order>) orderRepository.findAll();
	}

	public Order findById(String orderId) {
		logger.info("OrderService --> find ", orderId);
		return orderRepository.findById(orderId).orElse(null);
	}

	public boolean isProductAvailable(String productId, int quantity) {
		return inventoryClient.checkProductAvailability(productId, quantity);
	}

}
