package com.oliver.test;

import java.util.*;

/**
 * Created by ning on 9/2/16.
 */
public class CollectionTest {

    /** List */
    private List<Integer> arrayList=new ArrayList<Integer>();
    private List<Character> linkList=new LinkedList<Character>();

    /** set */
    private Set<Integer> hashSet=new HashSet<Integer>();
    private Set<Character> treeSet=new TreeSet<Character>();

    /** queue */
    private Queue<Integer> queue=new PriorityQueue<Integer>();

    /** Map */
    private Map<String,Integer> hashmap=new HashMap<String, Integer>();
    private Map<String,Integer> treeMap=new TreeMap<String, Integer>();

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
            System.out.println("item:"+ iterator.next());
        }
        String test="dfjdk";

    }

}
