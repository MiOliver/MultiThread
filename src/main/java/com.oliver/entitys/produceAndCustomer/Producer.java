package com.oliver.entitys.produceAndCustomer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ning on 1/14/16.
 */
public class Producer extends Thread {
    private Factory factory;

    public Producer(Factory factory){
        this.factory=factory;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("Producer -->"+"run");
            String goods=getRandomNum();
            factory.putOne(goods);
//            System.out.println(this.getName()+this.getId()+"--> produce "+ goods);
        }
    }

    private String getRandomNum(){
        Random random=new Random();
        int num=random.nextInt(20);
        return "goods"+num;
    }

    public void testMap() {
        Map<String, Date> map=getLimitedTime();
        if(map==null){
            System.out.println("map is null");
        }
    }

    public Map<String,Date> getLimitedTime(){
        Map<String,Date> map=new HashMap<String, Date>();
        String goodsIdList="1110,1200";
        String[] goodslist=goodsIdList.split(",");
        for(String goods:goodslist){
            map.put(goods,new Date());
        }
        return map;
    }
}
