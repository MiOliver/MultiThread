package com.oliver.net;

/**
 * Created by ning on 10/18/16.
 */
public class HttpClientTest {

    public static void main(String[] args){
        HttpExecute httpExecute=new HttpExecute();
        try{
            httpExecute.baseExecute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
