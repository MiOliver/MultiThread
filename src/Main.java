import entitys.*;
import entitys.produceAndCustomer.Customer;
import entitys.produceAndCustomer.Factory;
import entitys.produceAndCustomer.Producer;
import threadpool.PoolTest;
import utils.CommonUtils;
import utils.EnumTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ning on 1/14/16.
 */
public class Main{

    public static void main(String args[]){
        System.out.println("i am born!");
        CommonUtils.getProcessId();
        Factory factory = new Factory();
        Producer producer= new Producer(factory);
        Thread customer=new Thread(new Customer(factory));
        producer.setPriority(6);
        customer.setPriority(7);
        producer.start();
        customer.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("exit!");

    }

    public static void main02(String args[]){
        System.out.println("i am born!");
        MyCount myCount =new MyCount("89234984",1000);
        //创建锁对象
        Lock lock = new ReentrantLock();
        ExecutorService service= Executors.newCachedThreadPool();

        User user01=new User("sherry",myCount,200,lock);
        User user02=new User("sherry's father",myCount,20,lock);
        User user03=new User("sherry's mother",myCount,-50,lock);
        User user04=new User("sherry's brother",myCount,-320,lock);

        service.execute(user01);
        service.execute(user02);
        service.execute(user03);
        service.execute(user04);
        //关闭线程池
        service.shutdown();
    }
    public static void main03(String args[]){
        PoolTest test=new PoolTest();
        test.testCachedThreadPool();
        test.testSingleThreadExecutor();
        test.testFixedThreadPool();

        System.out.println("value "+EnumTest.Week.MONDAY.getValue());
        EnumTest.Week.MONDAY.getValue();
    }
}
