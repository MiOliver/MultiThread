package com.oliver.test;


import com.oliver.entitys.Outer;
import com.oliver.utils.DateUtil;
import org.apache.commons.lang.ObjectUtils;

import java.text.SimpleDateFormat;
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

//        System.out.println(new Date(2016,3,31));
//        System.out.println(new Date(2016,4,6));
//
//
//        System.out.println(DateUtil.strToDate("2016-03-31 00:00:00"));
//
//
//        String hour=new SimpleDateFormat("HH").format(new Date());
//        System.out.println(hour);
//
//        try {
//            Long imei=Long.valueOf("10254/12457852");
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }

//        int i=0;
//        System.out.println("i is "+i++);
//        Test test =new Test();
//        System.out.println("value is "+test.add(i));

        Outer outer=new Outer();

        /**成员内部类不能含有static的变量和方法。 因为成员内部类需要先创建了外部类，才能创建它自己的 */
        Outer.Inner inner= outer.new Inner("inner name",outer);
        System.out.println("成员内部类访问："+inner.getName());

        System.out.println("静态成员内部类访问："+ inner.getOuter().getOutName());
        System.out.println("静态成员内部类访问："+ inner.getOuter());

        Outer.StaicInner.addr="out.staticInner addr";
        /**静态内部类静态成员可以直接访问 */
        System.out.println("静态成员内部类访问："+ Outer.StaicInner.addr);

        /**静态内部类可以有自己的非静态成员变量，可以实例化 */
        Outer.StaicInner staicInner=new Outer.StaicInner("out.staticInner name");

        System.out.println("静态成员内部类访问："+ staicInner.getName());

        System.out.println("静态成员内部类访问："+ staicInner);

        System.out.println("<<"+(1L<<5));

    }

    public int add(int value){

        return ++value;
    }

}
