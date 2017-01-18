package com.oliver.hbase;

/**
 * Created by oliver on 2017/1/11.
 */
public class KeyDesign {

    public  static void main(String[] args){
        String key="https://dxer.github.io/2016/06/16/hbase_rowkey/";
        String key01="http://mi.app.com";
        String key02="https://mi.ol.a.com";
        System.out.println(key.hashCode());
        System.out.println(key01.hashCode());
        System.out.println(key02.hashCode());
        String[] weblist=new String[3];
        weblist[0]=key;
        weblist[1]=key01;
        weblist[2]=key02;
        try{
            for(String url:weblist){
                KeyUtil.getRowKey(url);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
