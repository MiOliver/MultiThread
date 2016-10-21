package com.oliver.pattern.decorator;

/**
 * 具体构建类
 */
public class ConcreteComponent implements ComponentInterface {
    @Override
    public void componentOpt() {
        System.out.println("具体构件接口方法");
    }
}
