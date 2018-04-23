package com.gray.base.util;



import redis.clients.jedis.Jedis;

public class Utils {

	private static Jedis jedis;
	
	public static Jedis getJedis() {
		if(jedis==null) {
			synchronized(Utils.class) {
				jedis=new Jedis();
			}
		}
		return jedis;
	}
	
	public static void closeJedis() {
		if(jedis!=null) {
			jedis.close();
		}
	}
	
	
}
