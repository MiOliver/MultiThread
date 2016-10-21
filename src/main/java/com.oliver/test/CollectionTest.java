package com.oliver.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ning on 9/2/16.
 */
public class CollectionTest {

    /** List */
    private List<Integer> arrayList=new ArrayList<Integer>();
    private List<Character> linkList=new LinkedList<Character>();

    private List<Character> copyList=new CopyOnWriteArrayList<Character>();

    /** set */
    private Set<Integer> hashSet=new HashSet<Integer>();
    private Set<Character> treeSet=new TreeSet<Character>();

    /** queue */
    private Queue<Integer> queue=new PriorityQueue<Integer>();

    /** Map */
    private Map<String,Integer> hashmap=new HashMap<String, Integer>();
    private Map<String,Integer> treeMap=new TreeMap<String, Integer>();

    private Map<String,Integer> linkdedHash=new LinkedHashMap<String, Integer>();

    private StringBuilder stringBuilder;
    private StringBuffer stringBuffer;

    public void testList(){
        Random randomInt=new Random();
        for(int i=0;i<6;i++){
            arrayList.add(i+randomInt.nextInt(10));
        }
        showCollection(arrayList);
        System.out.println("**************************");
        iteratorShow(arrayList);
    }

    public void testLinkedList(){
        Random randomInt=new Random();
        for(int i=0;i<5;i++){
            linkList.add(new Character((char)(i+80)));
        }
        showCollection(linkList);
        System.out.println("**************************");
        iteratorShow(linkList);
    }

    public void testHashSet(){
        System.out.println("************testHashSet**************");
        Random randomInt=new Random();
        for(int i=0;i<5;i++){
            hashSet.add(i+randomInt.nextInt(10));
        }
        showCollection(hashSet);
        System.out.println("**************************");
        iteratorShow(hashSet);
    }

    public void testTreeSetList(){
        System.out.println("*************testTreeSetList*************");
        Random randomInt=new Random();
        for(int i=0;i<5;i++){
            treeSet.add(new Character((char)(i+80)));
        }
        showCollection(treeSet);
        System.out.println("**************************");
        iteratorShow(treeSet);
    }


    public void showCollection(Collection collection){
        for(Object item:collection){
            System.out.println("type:"+item.getClass());
            System.out.println("item:"+item);
        }
    }

    public void iteratorShow (Collection collection){
        Iterator iterator=collection.iterator();
        while(iterator.hasNext()){
            Object item=iterator.next();
            System.out.println("type:"+ item.getClass());
            System.out.println("item:"+ item);
        }
        String test="dfjdk";

    }

    public void iteratorShowMap (Map map){
        Iterator<Map.Entry> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry=iterator.next();
            System.out.println("key:"+entry.getKey());
            System.out.println("value:"+ entry.getValue());
        }

        System.out.println("----------------------------------");

    }

    /**
     * 测试linkedHashMap  insert 顺序
     */
    public void testLink(){
        Map<String,Integer> linkdedHash=new LinkedHashMap<String, Integer>();
        linkdedHash.put("apple",10);
        linkdedHash.put("mi",100);
        linkdedHash.put("HW",13);
        linkdedHash.put("Lenovo",16);
        linkdedHash.put("apple",10);

        linkdedHash.get("Lenovo");
        linkdedHash.get("mi");

        iteratorShowMap(linkdedHash);
    }

    /**
     * 测试linkedHashMap  lru 顺序
     */
    public void testLinklru(){

        Map<String,Integer> linkdedHash=new LinkedHashMap<String, Integer>(20,0.7f,true);
        System.out.println(linkdedHash.size());
        linkdedHash.put("apple",10);
        linkdedHash.put("mi",100);
        linkdedHash.put("HW",13);
        linkdedHash.put("Lenovo",16);

        iteratorShowMap(linkdedHash);
        linkdedHash.get("Lenovo");
        linkdedHash.get("mi");

        iteratorShowMap(linkdedHash);
    }

    /**
     * test hashmap  null key
     */
    public void testHashMapNullKey(){
        hashmap.put(null,0);
        Integer pre= hashmap.put(null,1);
        System.out.println("value is "+pre);
        System.out.println("value is ");
    }

}
