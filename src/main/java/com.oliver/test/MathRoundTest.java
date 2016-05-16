package com.oliver.test;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ning on 4/1/16.
 * 四舍五入测试
 * 分开计算和总额计算精度控制
 */
public class MathRoundTest {

    public static final double TAX =0.05;

    public static void main(String[] args){
        BigDecimal te=new BigDecimal(32.2343);
        te.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(te.doubleValue());
        double price=5445.00;
        Double[] srcArray = {99.00,99.00,99.00,99.00,99.00,395.00,395.00,395.00,395.00,395.00,595.00,595.00,595.00,595.00,595.00};
        double total=0L;
        System.out.println((price/(1+TAX)*10000)/10000);
        for(double item:srcArray){
            item=(double)Math.round(item/(1+TAX)*10000)/10000;
            System.out.println("item: "+item);
            total+=item;
        }
        System.out.println(total);
    }


}
