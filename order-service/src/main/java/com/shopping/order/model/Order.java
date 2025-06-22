package com.shopping.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	private String orderId;
	private int quantity;
	private String paymentId;
	private String productId;

}
