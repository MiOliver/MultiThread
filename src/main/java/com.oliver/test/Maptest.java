package com.oliver.test;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

/**
 * Created by ning on 9/7/16.
 */
public class Maptest {

    private Map<String,String> map= Maps.newHashMap();

    public void testHashMap(){
        map.put(null,null);
        map.put(null,"test");
        Set<String> set=map.keySet();
        for(String key:set){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
    public static void main(String[] args){
//        CollectionTest collectionTest=new CollectionTest();
//        collectionTest.testLink();
//        collectionTest.testLinklru();
//        collectionTest.testHashMapNullKey();
        Maptest maptest=new Maptest();
        maptest.testHashMap();
    }
}
