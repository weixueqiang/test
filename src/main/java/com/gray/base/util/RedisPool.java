package com.gray.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

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
			config.setMaxTotal(Integer.parseInt(cfg.getProperty("maxTotal")));  
			config.setMaxIdle(Integer.parseInt(cfg.getProperty("maxIdle")));  
			config.setMaxWaitMillis(Long.parseLong(cfg.getProperty("waitMillis")));  
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
