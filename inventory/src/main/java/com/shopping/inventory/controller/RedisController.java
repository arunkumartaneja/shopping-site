package com.shopping.inventory.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.inventory.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@GetMapping("/keys")
	public Set<String> getAllKeys() {
		return redisService.getAllKeys();
	}

	@GetMapping("/value/{key}")
	public Object getValue(@PathVariable String key) {
		return redisService.getValue(key);
	}

	@PostMapping("/set")
	public void setValue(@RequestParam String key, @RequestParam String value) {
		redisService.setValue(key, value);
	}

	@DeleteMapping("/delete/{key}")
	public void deleteKey(@PathVariable String key) {
		redisService.deleteKey(key);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		redisService.deleteAll();
	}

}
