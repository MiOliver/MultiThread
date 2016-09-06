package com.oliver.pattern;

/**
 * 单例模式
 * Created by ning on 6/28/16.
 */
public class SingleTon {

    private static SingleTon  singleTon = null;

    public SingleTon() {
    }

    /** 恶汉氏单例模式**/
    synchronized static SingleTon getInstance(){
            if(singleTon==null){
                return singleTon=new SingleTon();
            }else{
                return singleTon;
            }
    }

    /** 双重锁定单例模式**/
     static SingleTon getInstance01(){
        if(singleTon==null){
            synchronized (SingleTon.class){
                if(singleTon==null){
                    return singleTon=new SingleTon();
                }else{
                    return singleTon;
                }
            }
        }else{
            return singleTon;
        }
    }

}
