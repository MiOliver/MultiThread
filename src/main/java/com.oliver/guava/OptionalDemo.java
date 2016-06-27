package com.oliver.guava;

import com.google.common.base.Optional;

/**
 * Created by ning on 6/1/16.
 */
public class OptionalDemo {
    public static void test(){
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5
    }
}
