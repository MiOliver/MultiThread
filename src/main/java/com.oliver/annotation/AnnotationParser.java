package com.oliver.annotation;

import java.lang.reflect.Method;

/**
 * Created by ning on 9/19/16.
 */
public class AnnotationParser {
    public static void main(String[] args) throws SecurityException, ClassNotFoundException {
        String clazz = "com.oliver.annotation.AnnotationDemo";
        Method[]  demoMethod = AnnotationParser.class
                .getClassLoader().loadClass(clazz).getMethods();

        for (Method method : demoMethod) {
            if (method.isAnnotationPresent(MethodAnno.class)) {
                MethodAnno authorInfo = method.getAnnotation(MethodAnno.class);
                System.out.println("method: "+ method);
                System.out.println("name= "+ authorInfo.name() +
                        " , site= "+ authorInfo.site()
                        + " , version= "+authorInfo.version());
            }
        }
    }
}
