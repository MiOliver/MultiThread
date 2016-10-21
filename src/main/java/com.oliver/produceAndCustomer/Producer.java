package com.oliver.produceAndCustomer;


import java.util.Random;

/**
 * Created by ning on 1/14/16.
 */
public class Producer extends Thread {
    private String Proname;
    private Factory factory;

    public Producer(String proname, Factory factory) {
        Proname = proname;
        this.factory = factory;
    }

    public String getProname() {
        return Proname;
    }

    public void setProname(String proname) {
        Proname = proname;
    }

    @Override
    public void run() {
        while (true){
            String goods=getRandomNum();
            factory.putOne(goods);
            System.out.println(getProname()+" put-->"+goods);
//            try{
//                Thread.sleep(3000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }
    }

    private String getRandomNum(){
        Random random=new Random();
        int num=random.nextInt(20);
        return "goods"+num;
    }



}
