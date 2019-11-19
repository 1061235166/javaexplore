package com.k.list;

import redis.clients.jedis.Jedis;


public class OtherView {

	public static void main(String[] args) {
		hyperhyperlog();
	}

	static void hyperhyperlog(){
		Jedis jedis = new Jedis();
		for (int i = 0; i < 100000; i++) {
			jedis.pfadd("codehole", "user" + i);
		}
		long total = jedis.pfcount("codehole");
		System.out.printf("%d %d\n", 100000, total);
	}
}
