package com.gray.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	private static JedisPool jedisPool=null;
	static {
		try {
			Properties cfg=new Properties();
			InputStream in = RedisPool.class.getClassLoader().getResourceAsStream("redis.properties");
			JedisPoolConfig config = new JedisPoolConfig();
			cfg.load(in);
			config.setMaxTotal(Integer.parseInt(cfg.getProperty("maxTotal")));//最大数量,-1不限制
			config.setMaxIdle(Integer.parseInt(cfg.getProperty("maxIdle")));  //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8
			config.setMaxWaitMillis(Long.parseLong(cfg.getProperty("waitMillis"))); 
//			在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
			config.setTestOnBorrow(Boolean.parseBoolean(cfg.getProperty("borrow"))); 
			jedisPool = new JedisPool(config, "localhost", 6379); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		}
	}
	
	public static synchronized Jedis getJedis() {
		if(jedisPool!=null) {
			return jedisPool.getResource();
		}
		return null;
	}
	
	public static void closeJedis(Jedis jedis) {
		if(jedis!=null) {
			jedis.close();
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(jedisPool);
		for (int i = 0; i < 11; i++) {
			Jedis jedis = getJedis();
			System.out.println(i+">>>>\n"+jedis);
			closeJedis(jedis);
		}
		
//		System.out.println(jedis.get("key1"));
         System.out.println("ok");
	}
	
	
}
