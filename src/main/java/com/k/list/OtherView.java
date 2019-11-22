package com.k.list;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;

import java.util.List;


public class OtherView {

	public static void main(String[] args) {
		geo();
	}

	static void hyperhyperlog(){
		Jedis jedis = new Jedis();
		for (int i = 0; i < 100000; i++) {
			jedis.pfadd("codehole", "user" + i);
		}
		long total = jedis.pfcount("codehole");
		System.out.printf("%d %d\n", 100000, total);
	}

	static void geo(){
		Jedis jedis = new Jedis();
		//解析地址的经纬度
		List<GeoCoordinate> cars = jedis.geopos("cars", "1","2");
		System.out.println(cars);
		//计算两点之间的距离
		Double aDouble = jedis.geodist("cars", "1", "2", GeoUnit.KM);
		System.out.println(aDouble);
		//计算以某个经纬度为中心某个半径内所有的坐标
		GeoRadiusParam geoRadiusParam = GeoRadiusParam.geoRadiusParam();
		GeoRadiusParam count = geoRadiusParam.withCoord().withDist().sortDescending().count(100);
		List<GeoRadiusResponse> responses = jedis.georadius("cars", 120.375821, 31.556381, 5, GeoUnit.KM,count);
		responses.forEach((res)->{
			System.out.println(res.getCoordinate());
			System.out.println(res.getDistance());
			System.out.println(res.getMemberByString());
		});

		List<String> cars1 = jedis.geohash("cars","1","2");
		System.out.println(cars1);
	}
}
