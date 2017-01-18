package com.oliver.hbase;

import org.apache.http.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by oliver on 2017/1/11.
 * hbase key 生成工具
 */
public class KeyUtil {

    private static final Logger logger = LoggerFactory.getLogger(KeyUtil.class);

    /**
     * url 转成 rowkey  (rowkey 格式: hashcode(url_part)_hashcode(url_part)_hashcode(url_part))
     * rowkey 长度35位
     * @param url
     * @return
     * @throws Exception
     */
    public static String getRowKey(String url) throws Exception{
        String part01="";
        String part02="";
        String part03="";
        String urlbody="";
        String domain="";
        Asserts.notEmpty(url,"");

        String[] parts=url.split("//");
        if(parts[0].startsWith("http")){
            urlbody=parts[1];
        }else{
            urlbody=url;
        }

        int index=urlbody.indexOf("/");
        if(index>=0){
            part01=urlbody.substring(index);
            domain=urlbody.substring(0,index);
        }else {
            domain=urlbody;
        }

        int mainNameindex=domain.indexOf(".");
        if(mainNameindex>=0){
            part03=domain.substring(mainNameindex);
            part02=domain.substring(0,mainNameindex);
        }else {
            part02=domain;
        }
        //如果第一部分为空,则part1放到最后
        if(part01.isEmpty()){
            part01=part02;
            part02=part03;
            part03="";
        }
        logger.debug("keySplit: is {}","part1:"+part01+",part2:"+part02+",part3:"+part03);
        System.out.println("part1:"+part01+",part2:"+part02+",part3:"+part03);
        String rowKey =String.format("%011d",part01.hashCode())+"_"+
                String.format("%011d",part02.hashCode())+"_"+
                String.format("%011d",part03.hashCode());
        return rowKey;
    }

}
