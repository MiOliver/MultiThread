package com.oliver.loader;

/**
 * Created by oliver on 2017/3/10.
 */
public class MyLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
