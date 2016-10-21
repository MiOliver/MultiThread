package com.oliver.produceAndCustomer;


/**
 * 生产者消费者
 * 待修改
 * Created by ning on 10/21/16.
 * TODO 多个消费者线程同时被唤醒，取到空的情况；相同消费者多添加的情况。
 */
public class FactoryTest {

    public static void main(String[] args){
        Factory factory=new Factory();
        Producer producer01=new Producer("Mi",factory);
        Producer producer02=new Producer("haha",factory);
        Producer producer03=new Producer("huawei",factory);

        Thread customer01=new Thread(new Customer("Cus01",factory));
        Thread customer02=new Thread(new Customer("Cus02",factory));
        Thread customer03=new Thread(new Customer("Cus03",factory));

        producer01.start();
        producer02.start();
        producer03.start();

        customer01.start();
        customer02.start();
        customer03.start();
    }

}
