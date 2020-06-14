package com.example.java.proxy;

/**
 * Created  on 2020/5/13.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 * proxy 动态代理设计模式
 */
public class HelloProxy implements IHello {
    @Override
    public void sayHello(String  str) {
        System.out.println(str);

    }

    @Override
    public void writeHello() {

    }
}
