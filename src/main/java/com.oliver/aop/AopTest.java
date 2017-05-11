package com.oliver.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by oliver on 2017/5/8.
 */
public class AopTest {

    public static void main(String[] args){

        /**被代理的真实对象 */
        CalculatorImpl calcImpl = new CalculatorImpl();

        /** 实际调用方法的handler  实际上 这就是 代理对象*/
        InvocationHandler handler = new ProxyFactory(calcImpl);
        /**
         * 参数1 用来定义代理类的 loader
         * 参数2 代理类要实现的接口
         * 参数3 分发方法调用的handler*/
        Calculator proxy =(Calculator) Proxy.newProxyInstance(handler.getClass().getClassLoader(),calcImpl.getClass().getInterfaces(),handler);

        int result = proxy.calculate(20, 10);
        System.out.print("FInal Result :::" + result);
    }

}
