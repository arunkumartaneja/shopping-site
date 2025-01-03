package com.shopping.payment.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@GetMapping
	public String pay(@RequestParam String orderId) {
		String paymentId = UUID.randomUUID().toString();
		String msg = "payment seccussfull for order: " + orderId + " and transection id: " + paymentId;
		logger.info(msg);
		return msg;
	}

}
