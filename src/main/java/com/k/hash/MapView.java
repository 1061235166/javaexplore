package com.k.hash;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by k on 2019/11/17.
 */
public class MapView {

    public static void main(String[] args) {
		idMap();
        hashMap();
		linkedhashmap();
    }

    static void idMap(){
        IdentityHashMap<String,String>map=new IdentityHashMap<>();
        map.put(new String("a"),"a");
        map.put("a","b");
        System.out.println(map);

        Map<String,String>hash=new HashMap<>();
		hash.put(new String("a"),"a");
		hash.put("a","b");
		System.out.println(hash);
    }

    static void hashMap(){
		Map<String,String>map = new HashMap<>();
		map.put("1321","1");
		map.put("2adf","2");
		map.put("32245sdf3","3");
		map.put("sdggfdjh","4");
		//遍历key无序,因为底层迭代器使用下标进行迭代
		for(String key:map.keySet()){
			System.out.println(key);
		}
		System.out.println();
    }

    static void linkedhashmap(){
		Map<String,String>map = new LinkedHashMap<>();
		map.put("1321","1");
		map.put("2adf","2");
		map.put("32245sdf3","3");
		map.put("sdggfdjh","4");
		//遍历key时有序,因为迭代器记录了put时before和next
		for(String key:map.keySet()){
			System.out.println(key);
		}
	}
}
