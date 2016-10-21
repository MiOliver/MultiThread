package com.oliver.pattern.adapter;

/**
 * 对象适配器模式
 */
public class ObjectAdapter implements TargetInterface {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    @Override
    public void operate01() {
        adaptee.operate();
    }

    @Override
    public void operate02() {

    }
}
