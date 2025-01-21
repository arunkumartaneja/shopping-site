package com.shopping.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.notification.service.NotificationProducer;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private NotificationProducer producer;

	@GetMapping("/publish")
	public String publish() {
		String message = "Hi!! there";
		logger.info("publishing message");

		producer.sendNotification("notification-topic", message);

		logger.info("Notification sent: " + message);

		return "Notification sent: " + message;
	}

}
