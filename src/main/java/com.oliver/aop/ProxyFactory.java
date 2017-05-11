package com.oliver.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by oliver on 2017/5/8.
 */
public class ProxyFactory implements InvocationHandler {

    private Object opt;

    public  ProxyFactory(Object opt) {
        this.opt = opt;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.opt, args);
            //执行原来的方法之后记录日志

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回方法返回值给调用者
        return result;
    }
}
