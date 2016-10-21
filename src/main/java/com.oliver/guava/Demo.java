package com.oliver.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by ning on 3/28/16.
 */
public class Demo {
    public static void main(String[] args) {
        list();
        System.out.println("**********************");
        immu();
        System.out.println("**********************");
        readFile();
        System.out.println("**********************");
        compare();
        System.out.println("**********************");
        matcher();
        System.out.println("**********************");
        joiner();
        System.out.println("**********************");
        function();
        System.out.println("**********************");
    }

    public static void list() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "001");
        map.put("2", "002");
        map.put("3", "003");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }

    public static void immu() {
        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
        for (String item : of) {
            System.out.println(item);
        }
    }

    public static void readFile() {
        File file = new File("/home/ning/Desktop/text.sh");
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
    }

    public static void compare() {
        int a=123;
        int b=323;
        int compare = Ints.compare(a, b);
        double c=123.72;
        double d=123.78;
        int comparedou =Doubles.compare(c,d);
        System.out.println("result is :"+comparedou);


    }

    public static void matcher() {
        String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
        System.out.println("result is :"+string);
        string = CharMatcher.DIGIT.removeFrom("some text 89983 and more");
        System.out.println("result is :"+string);
    }

    public static void joiner() {
        String[] subdirs = { "usr", "local", "lib" };
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);
        int[] numbers = { 1, 2, 3, 4, 5 };
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numbersAsString);
        String numbersAsStringDirectly = Ints.join(";", numbers);
        System.out.println(numbersAsStringDirectly);

        //contain
        int[] array = { 1, 2, 3, 4, 5 };
        int[] array2 = { 7, 8, 9, 11, 13 };
        int a = 4;
        boolean contains = Ints.contains(array, a);
        System.out.println("contains"+contains);
        int indexOf = Ints.indexOf(array, a);
        int max = Ints.max(array2);
        int min = Ints.min(array2);
        int[] concat = Ints.concat(array, array2);
        System.out.println(numbersAsStringDirectly);
    }


    public static void function() {
        ImmutableMap<String,Double> eurPriceMap =ImmutableMap.of();
       /* Map usdPriceMap = Maps.transformValues(eurPriceMap, new Function() {
            double eurToUsd = 1.4888;
            public Double apply(final Double from) {
                return from * eurToUsd;
            }
        });*/
        System.out.println("test");
    }




}
