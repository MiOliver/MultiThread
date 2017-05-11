package com.oliver.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oliver on 2017/3/30.
 */
public class DateTest {

    public static void main(String[] args){
        Date date=new Date();
        System.out.println(date.toString());
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true){
            try {
//                Date start= dateFormat.parse("2017-04-07 00:00:00");
//                Date end= dateFormat.parse("2017-04-10 00:00:00");
                Date start= dateFormat.parse("2017-03-30 10:17:00");
                Date end= dateFormat.parse("2017-03-30 10:18:00");
                Date now=new Date();
                if(now.after(start) && now.before(end)){
                    System.out.println(now.toString() +"true");
                }else {
                    System.out.println(now.toString() +"false");
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
        }

    }
}
