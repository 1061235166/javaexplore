package com.k.hash;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by k on 2019/11/17.
 */
public class MapView {

    public static void main(String[] args) {
        hashMap();
    }

    static void idMap(){
        IdentityHashMap<String,String>map=new IdentityHashMap<>();
        map.put(new String("a"),"a");
        map.put("a","b");
        System.out.println(map);
    }

    static void hashMap(){
        Map<String,String>map = new HashMap<>();
        map.put(new String("a"),"a");
        map.put("a","b");
        System.out.println(map);
    }
}
