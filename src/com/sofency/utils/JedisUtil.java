package com.sofency.utils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static final String HOST="106.12.208.167";//主机名
	private static final Integer PORT=6379;//端口号
	private static final String PASSWORD="sofency1234";//密码
	
	private static final Integer MAXIDLE=50;//最大空闲数
	private static final Integer MAXTOTAL=100;//最大连接数
	private static final Integer MAXWAITMILLIS=20000;//最大等待毫秒
	
	public static Jedis getResource() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(MAXIDLE);
		jedisPoolConfig.setMaxTotal(MAXTOTAL);
		jedisPoolConfig.setMaxWaitMillis(MAXWAITMILLIS);
		
		
		JedisPool jedisPool = new JedisPool(jedisPoolConfig,HOST,PORT);
		Jedis jedis = jedisPool.getResource();
		jedis.auth(PASSWORD);
		return jedis;
	}
	
	public static void close(Jedis jedis) {
		jedis.close();
	}
}
