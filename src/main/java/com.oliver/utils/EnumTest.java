package com.oliver.utils;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ning on 1/22/16.
 */
public class EnumTest {

    public static final Map<Integer,String> weekMap= new HashMap<Integer, String>(){
        public static final long serialVersionUID=-2714877298276523444L;
        {
            put(0,"心情");
        }
    };

    public enum  Week{
        MonDay("星期一"),
        TuesDay("星期二");

        private final String desc;
        private static final HashMap<Integer,Week> weekup=new HashMap<Integer,Week>();
        static {
            for(Week w:EnumSet.allOf(Week.class)){
                weekup.put(w.ordinal(),w);
            }
        }
        private Week(String desc){
            this.desc=desc;
        }
        public String getDesc(){
            return this.desc;
        }

        public static Week getWeek(int index){
            return weekup.get(index);
        }

    }

    public enum OrderOperaterType {
        CREATE,
        QUERY,
        QUERYLIST,
        RETURN,
        EXCHANGE,
        CHANGEIMEI,
        BROTHERS,
        INVOICE,
        COUPON,
        GETINSURANCE,
        GOODISINSTOCK;

    }

}
