package com.oliver.pattern;

import com.oliver.pattern.entity.AbstractChart;

/**
 * Created by ning on 6/28/16.
 */
public class PatternTest {

    public static void main(String[] args){
        AbstractChart chart=SimpleFactory.getChart("line");
        chart.display();
    }
}
