package com.oliver.aop;

/**
 * Created by oliver on 2017/5/8.
 */
public class CalculatorImpl implements Calculator{

    @Override
    public int calculate(int a, int b) {
        return a/b;
    }
}
