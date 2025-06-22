package com.shopping.payment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("PaymentDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail {

	@Id
	private String paymentId;
	private String orderId;
	private String productId;

}
