package com.oliver.entitys;

/**
 * Created by ning on 16-1-17.
 */
public class MyTask implements Runnable{
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("当前线程："+this.name+" 执行中...");
    }
}
