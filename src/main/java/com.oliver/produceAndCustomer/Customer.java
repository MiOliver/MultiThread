package com.oliver.produceAndCustomer;

/**
 * Created by ning on 1/14/16.
 */
public class Customer implements Runnable{

    private String cusName;
    private Factory factory;

    public Customer(String cusName, Factory factory) {
        this.cusName = cusName;
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true){
            String goods=factory.takeOne();
            System.out.println(getCusName()+" take <--"+ goods);
//            try{
//                Thread.sleep(2000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }

        }
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
