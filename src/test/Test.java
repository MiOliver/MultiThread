package test;

import entitys.produceAndCustomer.Customer;
import entitys.produceAndCustomer.Factory;
import entitys.produceAndCustomer.Producer;
import utils.CommonUtils;
import utils.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ning on 3/24/16.
 */
public class Test {
    public static void main(String args[]){
//        Calendar calendar=Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH,-16);
//        calendar.add(Calendar.WEEK_OF_MONTH,-2);
//        System.out.println("time"+calendar.getTime());

        System.out.println(new Date(2016,3,31));
        System.out.println(new Date(2016,4,6));


        System.out.println(DateUtil.strToDate("2016-03-31 00:00:00"));

    }
}
