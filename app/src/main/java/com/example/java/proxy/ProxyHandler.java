package com.example.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created  on 2020/5/13.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 * 动态代理处理类
 */
public class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    // 动态代理可以在某个方法执行之前植入某行代码
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        if(objects!=null&&objects.length>0){
            if(objects[0] instanceof String){
                objects[0] ="小小英雄";
            }
        }
        method.invoke(object, objects);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
