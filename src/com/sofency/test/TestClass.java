package com.sofency.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestClass {
	
	
	@Test
	public void demo() {
		JedisPool jedisPool = new JedisPool("106.12.208.167",6379);
		Jedis jedis = jedisPool.getResource();
		jedis.auth("sofency1234");//授权密码
		System.out.println(jedis.get("name"));
		
	}
	

}
