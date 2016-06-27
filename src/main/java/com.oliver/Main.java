package com.oliver;

import com.oliver.entitys.MyCount;
import com.oliver.entitys.User;
import com.oliver.entitys.produceAndCustomer.Customer;
import com.oliver.entitys.produceAndCustomer.Factory;
import com.oliver.entitys.produceAndCustomer.Producer;
import com.oliver.utils.CommonUtils;
import com.oliver.utils.DateUtil;
import com.oliver.utils.EnumTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ning on 1/14/16.
 */
public class Main{

    private static final int MAX_SIZE = 9999999;
    public static void main(String args[]){
        testDate();
    }

    public static void testThread(){
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
    public static void test(){
        System.out.println("当前时间："+ DateUtil.date2str("yyyy-mm-dd hh:MM:ss"));
        System.out.println("time is :"+DateUtil.dateToTimestamp(DateUtil.strToDate("2016-04-6 23:59:58")));
        System.out.println("time is :"+DateUtil.dateToTimestamp(DateUtil.strToDate("2016-04-6 23:59:59")));
        System.out.println("time check:"+DateUtil.strToDate("2016-04-06 23:59:58").before(DateUtil.strToDate("2016-04-6 23:59:59")));
        System.out.println("value "+ EnumTest.Week.MonDay.getDesc());
    }

    public static void test01(){
        String dateStr= (DateUtil.dateToInt(new Date()))+"";
        int random= getRandomInt(10000);
        System.out.println(fillStr(random));
        System.out.println(dateStr+fillStr(random));
    }

    private static String fillStr(Integer value){
        String mkup_zero = ((MAX_SIZE+1)+"").substring(1);
        String new_value = mkup_zero+value;
        new_value=new_value.substring(new_value.length()-(MAX_SIZE+"").length(), new_value.length());
        return new_value;
    }


    private static int getRandomInt(int range){
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(range);
    }

    private static void testString(){
        BigDecimal test=new BigDecimal(100.34);
        System.out.println("test String :"+test.setScale(1,BigDecimal.ROUND_HALF_EVEN).doubleValue());
    }

    private static void testDate(){
        Date date=new Date(2016-1900,4,14);
        System.out.println("test date :"+date);
        System.out.println("test date :"+new Date(2016-1900,5,9));
    }

    private static void testHashMap(){
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("test","001");
        resultMap.put("test","002");
        Set<String> keys=resultMap.keySet();
        for(String key:keys){
            System.out.println("key:"+resultMap.get(key));
        }

    }



}
