package com.example.java;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2018/7/17.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class DesignModel {
    /**
     * 单例模式1 线程不安全的懒汉模式
     */
    public static class Singleton1 {
        public static Singleton1 instance;

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 单例模式2 线程安全的懒汉模式
     */
    public static class Singleton2 {
        public static Singleton2 instance;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 单例模式3 静态内部类
     */
    public static class Singleton3 {
        public static class SingletonHolder {
            public static Singleton3 instance = new Singleton3();
        }


        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            return SingletonHolder.instance;
        }
    }

    /**
     * 单例模式2 饿汉模式
     */
    public static class Singleton4 {
        public static Singleton4 instance = new Singleton4();

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式2 双重校验锁法
     */
    public static class Singleton5 {
        public static volatile Singleton5 instance;

        private Singleton5() {
        }

        public static Singleton5 getInstance() {
            if (instance == null) {
                synchronized (Singleton5.class) {
                    if (instance == null) {
                        instance = new Singleton5();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 建造者模式
     */
    public static class BuilderModel {
        private String Test1;
        private String Test2;
        private String Test3;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public BuilderModel setTest1(String test) {
            this.Test1 = test;
            return this;
        }

        public BuilderModel setTest2(String test) {
            this.Test2 = test;
            return this;
        }

        public BuilderModel setTest3(String test) {
            this.Test3 = test;
            return this;
        }

        public void build() {
            textView1.setText(Test1);
            textView2.setText(Test2);
            textView3.setText(Test3);
        }
    }

    /**
     * 观察者模式
     */

    public static class ObserverModel {
        /**
         * 抽象观察者接口
         * 声明注册，删除，通知观察者方法
         */
        public interface Observerable {
            void registerObserver(Observer o);

            void removeObserver(Observer o);

            void notifyObserver();
        }

        /**
         * 定义抽象观察者接口
         */
        public interface Observer {
            void update(String message);
        }

        /**
         * 被观察者
         */
        public class WatchServer implements Observerable {
            private List<Observer> list;
            private String msg;

            public WatchServer() {
                list = new ArrayList<>();
            }


            @Override
            public void registerObserver(Observer o) {
                list.add(o);

            }

            @Override
            public void removeObserver(Observer o) {
                if (!list.isEmpty()) {
                    list.remove(o);
                }

            }

            @Override
            public void notifyObserver() {
                for (int i = 0; i < list.size(); i++) {
                    Observer observer = list.get(i);
                    observer.update(msg);
                }

            }

            public void setInformation(String s) {
                this.msg = s;
                notifyObserver();
            }
        }

        /**
         * 观察者
         * 实现了update方法
         */
        public class User implements Observer {
            private String name;
            private String message;

            public User(String name) {
                this.name = name;
            }

            @Override
            public void update(String message) {
                this.message = message;
                read();
            }

            public void read() {
                System.out.println(name + " 收到推送消息： " + message);
            }

        }

        public class Test {

            public void TestObserverModelRun() {
                WatchServer server = new WatchServer();

                Observer userZhang = new User("ZhangSan");
                Observer userLi = new User("LiSi");
                Observer userWang = new User("WangWu");

                server.registerObserver(userZhang);
                server.registerObserver(userLi);
                server.registerObserver(userWang);
                server.setInformation("PHP是世界上最好用的语言！");

                System.out.println("----------------------------------------------");
                server.removeObserver(userZhang);
                server.setInformation("JAVA是世界上最好用的语言！");

            }

        }
    }

    /**
     * 策略模式
     */
    public static class TactfulModel{
        public interface WeaPon{
            void gun();
        }

        public class FirstFunction implements WeaPon{

            @Override
            public void gun() {
                System.out.println("切换成第一个功能");
            }
        }
        public class SecondFunction implements WeaPon{

            @Override
            public void gun() {
                System.out.println("切换成第二个功能");
            }
        }

        /**
         * 策略模式
         * 介质，切换功能
         */
        public class Medium{
           private WeaPon weaPon;
            public Medium(WeaPon weaPon){
                this.weaPon =weaPon;
            }

            public WeaPon getWeaPon() {
                return weaPon;
            }

            public void setWeaPon(WeaPon weaPon) {
                this.weaPon = weaPon;
            }
            public void gun(){
                weaPon.gun();
            }
        }

        public class TactfulModelTest {

            public  void main() {
                //使用构造函数默认选择第一个功能（一个策略）
                Medium medium=new Medium(new FirstFunction());
                medium.gun();

                //使用set方法切换到第二个功能（切换策略）

                medium.setWeaPon(new SecondFunction());

                medium.gun();
            }
        }

    }




}
