package com.oliver.pattern.Interface;

/**
 * 观察者类
 */
public class Obsever {

    private String data;

    public Obsever(String data) {
        this.data = data;
    }

    public void update(String value){
        System.out.println("pre data "+data);
        data=value;
        System.out.println("new data "+data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
