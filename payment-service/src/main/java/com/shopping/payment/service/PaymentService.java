package com.shopping.payment.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.payment.model.PaymentDetail;
import com.shopping.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	public String pay(String orderId, String productId) {
		String paymentId = UUID.randomUUID().toString();
		String msg = "payment seccussfull for order: " + orderId + " and transection id: " + paymentId;
		logger.info(msg);

		PaymentDetail paymentDetail = new PaymentDetail(paymentId, orderId, productId);
		paymentRepository.save(paymentDetail);
		return paymentId;
	}

	public List<PaymentDetail> findAll() {
		logger.info("PaymentDetail --> findAll ");
		return (List<PaymentDetail>) paymentRepository.findAll();
	}

	public PaymentDetail findById(String orderId) {
		logger.info("PaymentDetail --> find ", orderId);
		return paymentRepository.findById(orderId).orElse(null);
	}

}
