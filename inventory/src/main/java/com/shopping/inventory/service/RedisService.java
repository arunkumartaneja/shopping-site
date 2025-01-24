package com.shopping.inventory.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
//	@Autowired
//    private RedisTemplate<String, Object> redisTemplate;

	public Set<String> getAllKeys() {
		return redisTemplate.keys("*");
	}

	public Object getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void setValue(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void deleteKey(String key) {
		redisTemplate.delete(key);
	}

	public void deleteAll() {
		redisTemplate.getConnectionFactory().getConnection().serverCommands().flushAll();
	}

}
