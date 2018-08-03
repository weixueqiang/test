package com.gray.base.util;

import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gray.user.entity.User;

import redis.clients.jedis.JedisPoolConfig;

public class StringRedisTemplateUtils {

	
	public static void main(String[] args) {
		
		JedisPoolConfig poolConfig=new JedisPoolConfig();
		poolConfig.setMaxTotal(1024);
		poolConfig.setMaxIdle(20);
		poolConfig.setMaxWaitMillis(1000L);
		poolConfig.setTestOnBorrow(true);
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setDatabase(1);
		jedisConnectionFactory.setPoolConfig(poolConfig);
		jedisConnectionFactory.setHostName("192.168.99.54");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.setPassword("");
		System.out.println(jedisConnectionFactory);
		System.out.println("启动完成");
//		JedisConnection connection = jedisConnectionFactory.getConnection();
//		connection.set("test".getBytes(), "ttt".getBytes());
		RedisTemplate<String,Object> redisTemplate=new RedisTemplate<String,Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setEnableTransactionSupport(false);
		User user = new User(123, "zhangsan", "zs123", "salt");
		redisTemplate.opsForValue().set("user", user);
//		redisTemplate.opsForList().leftPush("user", user);
//		redisTemplate.opsForList().leftPop("user");
	}
	
	
}
