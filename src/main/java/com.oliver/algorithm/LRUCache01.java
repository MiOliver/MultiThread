package com.oliver.algorithm;

import org.apache.commons.collections.map.LinkedMap;

import java.util.Iterator;
import java.util.Map;

/**
 * LRU 页面置换算法
 */
public class LRUCache01 {

    private LinkedMap cache=null;
    private int capacity;

    public LRUCache01(int capacity) {
        this.capacity = capacity;
        this.cache =new LinkedMap();
    }

    public Object get(String key){
        if(cache.keySet().contains(key)){
            return cache.get(cache.indexOf(key));     //访问到之后，当前元素放到链表尾部，便于remove
        }
        return "null";
    }


    public void set(String key,String value){
        if(cache.keySet().contains(key)){
            cache.put(key,value);
        }else{
            //移除+put
            if(cache.size()==capacity){
                cache.remove(cache.firstKey());
            }
            cache.put(key,value);
        }
    }



    public void show(){
        Iterator<Map.Entry<String,String>> iterator=cache.entrySet().iterator();
        Map.Entry entry=null;
        while(iterator.hasNext()){
            entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("************************************");
    }

    public static void main(String[] args){
        LRUCache lruCache=new LRUCache(3);
        lruCache.set("1","apple");
        lruCache.set("2","tea");
        lruCache.set("3","moon");
        lruCache.get("2");
        lruCache.set("4","sun");
        lruCache.show();
    }


}
