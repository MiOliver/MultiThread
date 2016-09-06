package com.oliver.pattern;

import com.oliver.pattern.Interface.TargetInterface;
import com.oliver.pattern.entity.Adaptee;

/**
 * 类适配器模式
 * Created by ning on 9/5/16.
 */
public class ClassAdapter extends Adaptee implements TargetInterface {
    @Override
    public void operate01() {
        System.out.println("class adapter op1");
    }

    @Override
    public void operate02() {
        System.out.println("class adapter op2");
    }
}
