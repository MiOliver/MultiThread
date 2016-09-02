package com.oliver;

import com.oliver.entitys.MyCount;
import com.oliver.entitys.User;
import com.oliver.entitys.produceAndCustomer.Customer;
import com.oliver.entitys.produceAndCustomer.Factory;
import com.oliver.entitys.produceAndCustomer.Producer;
import com.oliver.test.CalendarTest;
import com.oliver.test.CollectionTest;
import com.oliver.utils.CommonUtils;
import com.oliver.utils.DateUtil;
import com.oliver.utils.EnumTest;
import com.sun.tools.javac.util.Assert;

import javax.swing.plaf.synth.SynthTextAreaUI;
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
    public static String ips="10.100.*.* ,10.208.*.*,10.248.*.*,10.234.*.*,10.237.*.*,10.201.*.*,223.202.34.*,223.202.68.*,223.202.36.*,10.236.*,10.108.39.*,10.108.66.*,10.108.70.*,10.108.69.*,10.108.68.*,10.64.*.*,10.235.120.*,10.245.*.*,10.112.*.*";
    public static void main(String args[]){
        CollectionTest test=new CollectionTest();
        test.testList();
        test.testLinkedList();
//        test.testHashSet();
//        test.testTreeSetList();
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


    private static void testList(){
        List<String> orderList=new ArrayList<String>(
        );
        orderList.add("test");
        orderList.add("te");
        orderList.add("t1");
        Iterator<String> iterator=orderList.iterator();
        for(String item:orderList){
            System.out.println(item);
        }
        while (iterator.hasNext()){
            String item=iterator.next();
            if(item.contains("tes")){
                iterator.remove();
            }
        }

        for(String item:orderList){
            System.out.println(item);
        }

    }

    private static void testList01(){
        List<String> orderList=new ArrayList<String>(
        );
        orderList.add("test");
        orderList.add("t1");

        if(orderList.contains("te")){
            System.out.println("contain");
        }else{
            System.out.println("nocontain");
        }

    }

    private static void testip(){
        try{
           boolean f= filterIp("10.64.0.47",ips);
            System.out.println("result="+f);
        }catch(Exception e){

        }


    }

    public static boolean filterIp(String ip,String ipReg) throws Exception{
        boolean flag = false;
        String[] ipRegs = ipReg==null?null:ipReg.split(",");
        for(String tmpIp : ipRegs){
            if(ip.matches(tmpIp.trim()) || ip.matches("127.0.0.1")){
                flag = true ;
            }
        }
        if(!flag){
            throw new Exception("请选择授权wifi进行交易"+";Ip is:"+ip);
        }
        return flag;
    }
    public  static void testMap() {
        Map<String, Date> map=getLimitedTime();
        if(map==null){
            System.out.println("map is null");
        }
    }

    public static Map<String,Date> getLimitedTime(){
        Map<String,Date> map=new HashMap<String, Date>();
            String goodsIdList="1110,1200";
            String[] goodslist=goodsIdList.split(",");
            for(String goods:goodslist){
                map.put(goods,new Date());
            }
        return map;
    }

    private static void testenum(){

        System.out.println("enum:"+EnumTest.OrderOperaterType.QUERY);
        System.out.println("enum:"+EnumTest.OrderOperaterType.CREATE);
    }




}
