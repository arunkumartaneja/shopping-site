package com.shopping.payment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.payment.model.PaymentDetail;
import com.shopping.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/pay")
	public String pay(@RequestParam String orderId, @RequestParam String productId) {
		return paymentService.pay(orderId, productId);
	}

	@GetMapping
	public List<PaymentDetail> getPaymentDetails() {
		logger.info("PaymentController --> getPaymentDetails ");
		return paymentService.findAll();
	}

	@GetMapping("/{paymentId}")
	public PaymentDetail getPaymentDetail(@PathVariable String paymentId) {
		logger.info("PaymentController --> getPaymentDetails ", paymentId);
		return paymentService.findById(paymentId);
	}

}
