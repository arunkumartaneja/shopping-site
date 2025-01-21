package com.shopping.notification.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Sent message: " + message + " to topic: " + topic);
    }

}
