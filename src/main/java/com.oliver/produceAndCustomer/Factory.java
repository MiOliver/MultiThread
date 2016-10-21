package com.oliver.produceAndCustomer;

import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * Created by ning on 1/14/16.
 */
public class Factory {
    private Queue<String> store = null;

    public Factory() {
        store = Queues.newArrayDeque();
    }

    public synchronized String takeOne() {
        String outgoods="";
        if (store.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            outgoods = store.poll();
            this.notify();
        }

        return outgoods;

    }

    public synchronized void putOne(String item) {
        if (store.size() >= 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        store.add(item);
        System.out.println("size ="+store.size());
        this.notify();
    }

}
