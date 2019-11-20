package com.k.hash;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import org.apache.commons.collections4.bag.HashBag;

import java.util.*;

/**
 * Created by k on 2019/11/17.
 */
public class MapView {

    public static void main(String[] args) {
		hashBag();
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

	static void weakHashMap(){
		WeakHashMap<Integer,String> map=new WeakHashMap<>();

		map.put(new Integer(1),"123");
		System.out.println(map);
		System.gc();
		//gc后map被清空
		System.out.println(map);
	}

	static void bimap(){
		BiMap<String,Integer> map = HashBiMap.create();
		map.put("11",111);
		map.put("22",222);
		map.put("33",333);
		map.put("44",444);
		System.out.println(map);
		//key和value倒转
		BiMap<Integer, String> inverse = map.inverse();
		System.out.println(inverse);
	}

	static void multimap(){
		HashMultimap<String, String> multimap = HashMultimap.create();
		multimap.put("key","value1");
		multimap.put("key","value2");
		multimap.put("key","value3");
		System.out.println(multimap);
		Set<String> key = multimap.get("key");
		System.out.println(key);
	}

	static void hashBag(){
		HashBag<String>bag = new HashBag<>();
		bag.add("1");
		bag.add("1");
		bag.add("2",3);
		System.out.println(bag.getCount("2"));
		System.out.println(bag.getCount("1"));
	}
}
