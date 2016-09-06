package com.oliver.algorithm;

/**
 * Created by ning on 9/5/16.
 */
public class SortUtils {

    public static void insertSort(Integer[] array){
        if(array.length==0){
            return;
        }
        for(int i=1;i<array.length;i++){
            int tem=array[i];
            int j=i-1;
            for(;j>=0&&array[j]>tem;j--){
                array[j+1]=array[j];
            }
            array[j+1]=tem;
        }
        for(int item:array){
            System.out.println(item+",");
        }
    }

    public static void shellSort(Integer[] array){
        if(array.length==0){
            return;
        }
        int d1=array.length;
        while (true){
            d1=(int)Math.ceil(d1/2);
            int d=d1;
            for(int i=1;i<array.length;i=i+d){
                int tem=array[i];
                int j=i-d;
                for(;j>=0&&array[j]>tem;j=j-d){
                    array[j+d]=array[j];
                }
                array[j+d]=tem;
            }
            if(d==1){
                break;
            }
        }

        for(int item:array){
            System.out.println(item+",");
        }
    }
}
