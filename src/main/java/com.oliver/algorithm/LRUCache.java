package com.oliver.algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 页面置换算法
 */
public class LRUCache {

    private LinkedHashMap<String,String> cache=null;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache =new LinkedHashMap<String, String>(capacity,0.7f,true);
    }

    public String get(String key){
        if(cache.keySet().contains(key)){
            return cache.get(key);     //访问到之后，当前元素放到链表尾部，便于remove
        }
        return "null";
    }


    public void set(String key,String value){
        if(cache.keySet().contains(key)){
            cache.put(key,value);
        }else{
            //移除+put
            if(cache.size()==capacity){
                removeFirst();
            }
            cache.put(key,value);
        }
    }

    public void removeLast(){
        Iterator<Map.Entry<String,String>> iterator=cache.entrySet().iterator();
        Map.Entry entry=null;
        while(iterator.hasNext()){
            entry=iterator.next();
        }
        cache.remove(entry);
    }

    public void removeFirst(){
        Iterator<Map.Entry<String,String>> iterator=cache.entrySet().iterator();
        Map.Entry entry=null;
        entry=iterator.next();
        cache.remove(entry.getKey());
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
        lruCache.show();
        lruCache.get("1");
        lruCache.show();
        lruCache.set("4","sun");
        lruCache.show();
    }


}
