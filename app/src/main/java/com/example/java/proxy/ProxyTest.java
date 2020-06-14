package com.example.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created  on 2020/5/13.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class ProxyTest {
    public static void main(String[] args) {
        IHello hello = new HelloProxy();
        InvocationHandler handler = new ProxyHandler(hello);
        IHello proxyHello = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello("皮克斯");
        proxyHello.writeHello();
    }

}
