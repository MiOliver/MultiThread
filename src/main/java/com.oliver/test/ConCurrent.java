package com.oliver.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.jersey.client.impl.CopyOnWriteHashMap;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ning on 9/20/16.
 */
public class ConCurrent {

    CopyOnWriteArrayList<String> copy= Lists.newCopyOnWriteArrayList();
    CopyOnWriteArraySet<String> copyOnWriteArraySet= Sets.newCopyOnWriteArraySet();
    CopyOnWriteHashMap<String,Integer> copyOnWriteHashMap;

    ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public static void main(String[] args){
        final AtomicInteger atomicInteger=new AtomicInteger(0);
        for(int i=0;i<100;i++){
            Thread thread =new Thread(new Mythread(atomicInteger));
            thread.start();
        }
    }


}

class Mythread implements Runnable{
    private AtomicInteger AInteger;

    public Mythread(AtomicInteger AInteger) {
        this.AInteger = AInteger;
    }

    @Override
    public void run() {
        this.AInteger.getAndAdd(1);
        System.out.println("value is "+this.AInteger.get());
    }

}
