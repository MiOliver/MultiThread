package com.oliver.algorithm;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * Created by ning on 9/12/16.
 */
public class TestFind {



    public TestFind() {
        Random random=new Random();

    }

    /**
     * 非递归查找
     * @param array
     */
    public void find(List<Integer> array,Integer value){
        int low=0;
        int high=array.size();
        while (low<high){
            int middle=(int)Math.ceil((low+high)/2);
            if(array.get(middle)==value){
                System.out.println("position is :"+middle+";"+array.get(middle));
                break;
            }else if(array.get(middle)>value){
                high=middle-1;
            }else{
                low=middle+1;
            }
        }
    }

    /**
     * 递归查找
     * @param array
     * @param value
     */
    public void findDi(List<Integer> array,int min,int max,Integer value){
        if(min<=max){
            int middle=(int)Math.ceil((min+max)/2);
            if(array.get(middle)==value){
                System.out.println("position is :"+middle+";"+array.get(middle));
            }else if(array.get(middle)>value){
                findDi(array,min,middle-1,value);
            }else{
                findDi(array,middle+1,max,value);
            }
        }else {
            System.out.println("there is no this element!");
        }
    }

    public static void main(String[] args){
        List<Integer> array= Lists.newArrayList();
        for(int i=0;i<10;i++){
            array.add(i*2);
        }
        TestFind testFind=new TestFind();
        testFind.find(array,12);
        testFind.findDi(array,0,array.size(),16);
    }

}
