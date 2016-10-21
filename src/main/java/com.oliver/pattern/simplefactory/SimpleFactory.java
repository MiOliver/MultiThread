package com.oliver.pattern.simplefactory;

import com.oliver.pattern.entity.AbstractChart;
import com.oliver.pattern.entity.LineChart;
import com.oliver.pattern.entity.PieChart;

/**
 * 简单工厂模式 (抽象商品，工厂不抽象，)
 **/
public class SimpleFactory {

    public static AbstractChart getChart(String name){
        if (name.equals("line")) {
            return new LineChart();
        }else{
            return new PieChart();
        }
    }
}
