package com.shopping.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

//    @Bean
//    WebClient webClient(WebClient.Builder builder) {
//		return builder.baseUrl("http://GATEWAY-SERVICE").build();
//	}

	@Bean
	@LoadBalanced // Enable service name resolution via Eureka
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
