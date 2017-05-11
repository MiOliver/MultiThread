package com.oliver.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by oliver on 2017/5/8.
 */
public class SomeHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        Object result = method.invoke(proxy ,params);
        return result;
    }

}
