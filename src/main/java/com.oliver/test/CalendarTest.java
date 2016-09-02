package com.oliver.test;

import com.oliver.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ning on 8/10/16.
 */
public class CalendarTest {

    public static void test(){
        Calendar cal=Calendar.getInstance();
        cal.set(2016,7,8,0,20,32);
        System.out.println("***************************************************");
        System.out.println("当前时间："+cal.getTime());
        System.out.println("当前时间段："+cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("当前时间Hour："+cal.get(Calendar.HOUR));
        System.out.println("当前时间minite："+cal.get(Calendar.MINUTE));
    }

    public static void testDate(){
        Date date =new Date();
        System.out.println("***************************************************");
        System.out.println("当前时间："+ DateUtil.date2str(date,"yyyyMMddHH"));
        System.out.println("当前时间："+ DateUtil.dateToInt(date));
        System.out.println("当前时间："+DateUtil.dateToInt(date)+"0100");

    }

}
