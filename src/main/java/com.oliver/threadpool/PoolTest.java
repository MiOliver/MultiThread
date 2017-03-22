package com.oliver.threadpool;


import com.oliver.entitys.MyTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Created by ning on 16-1-17.
 */
public class PoolTest {


    public void testCachedThreadPool(){
        ExecutorService service=Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            MyTask task=new MyTask(String.valueOf(i));
            service.execute(task);
            System.out.println();

        }
        service.shutdown();
    }

    public void testSingleThreadExecutor(){
        ExecutorService service=Executors.newSingleThreadExecutor();
        for(int i=0;i<50;i++){
            MyTask task=new MyTask(String.valueOf(i));
            service.execute(task);
            System.out.println();
        }
        service.shutdown();
    }

    public void testFixedThreadPool(){
        ExecutorService service=Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            MyTask task=new MyTask(String.valueOf(i));
            service.execute(task);
            System.out.println();

        }
        service.shutdown();
    }

    public void testEnum(){
        System.out.println("testenum");
        Lock lock= LockSupport.INSTANCE.getLock("test");
        lock.lock();

        lock.unlock();
    }

    public static void  main(String[] args){
        PoolTest test=new PoolTest();
        for(int i=0;i<3;i++){
            test.testEnum();
        }
    }

}
