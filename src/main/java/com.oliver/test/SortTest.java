package com.oliver.test;

import com.oliver.algorithm.SortUtils;

/**
 * Created by ning on 9/5/16.
 */
public class SortTest {

    public static void main(String[] args){
        Integer[] array={12,4,5,32,123,64,4,75,85,53,7,43,8,48,87};
//        SortUtils.insertSort(array);
//        System.out.println("******shell***********");
//        SortUtils.shellSort(array);

//        System.out.println("******select***********");
//        SortUtils.selectSort(array);

        System.out.println("******quick sqrt()***********");
        SortUtils.selectSort(array);

    }

}
