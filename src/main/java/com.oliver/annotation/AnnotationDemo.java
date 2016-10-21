package com.oliver.annotation;

/**
 * Created by ning on 9/19/16.
 */
public class AnnotationDemo {
    @MethodAnno(name = "main",site = "ning.com",version = 1)
    public static void main(String[] args){
        System.out.println("main");
    }
    @MethodAnno(name = "demo",site = "ning.com",version = 2)
    public void demoMethod(){

    }
}
