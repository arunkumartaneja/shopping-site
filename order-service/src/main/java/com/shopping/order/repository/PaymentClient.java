package com.shopping.order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class PaymentClient {

//	@Autowired
//	public WebClient webClient;

	@Autowired
	private WebClient.Builder webClientBuilder;

	public String pay(String orderId) {
		String url = "http://GATEWAY-SERVICE/payments/api/v1/pay?orderId=" + orderId;

		// Use block() only for synchronous calls
//		Boolean isAvailable = webClient.get().uri(url).retrieve().bodyToMono(Boolean.class).block();

		try {
//			return webClient.get().uri(url).retrieve().bodyToMono(String.class).block();
			return webClientBuilder.build().get().uri(url) // Use service name
					.retrieve().bodyToMono(String.class).block();
		} catch (WebClientResponseException e) {
			System.err.println("Error response from Payment Service: " + e.getStatusCode());
			return "Error response from Payment Service: " + e.getStatusCode();
		} catch (Exception e) {
			System.err.println("Error calling Payment Service: " + e.getMessage());
			return "Error calling Payment Service: " + e.getMessage();
		}

	}
}
