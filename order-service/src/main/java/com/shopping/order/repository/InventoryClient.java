package com.shopping.order.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gateway-service")
public interface InventoryClient {

	@GetMapping("/inventory/api/v1/product/check")
	boolean checkProductAvailability(@RequestParam String productId, @RequestParam int quantity);

}
