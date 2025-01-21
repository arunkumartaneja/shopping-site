package com.shopping.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

	@KafkaListener(topics = "notification-topic", groupId = "notification-service-group")
	public void consumeMessage(String message) {
		System.out.println("Received message: " + message);
	}

}
