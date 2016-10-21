package com.oliver.annotation;

import java.lang.annotation.*;

/**
 * Created by ning on 9/19/16.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnno {
    String name();
    String site() default "ning";
    int version() default 1;
}
