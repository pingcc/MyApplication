package com.example.java;

/**
 * Created by user on 2017/6/20.
 */

public class TestJava {
   private jaa testJava;
    public static void main(String []args){
        int i;
        for (i = 0; i < 10; i++)
        {
            System.out.println(array(i));
        }

    }
    void ls(){
        testJava =new jaa();
    }
    class jaa{

    }

    //斐波那契数列
    private static int array(int i){
        if(i==0)
            return 0;
        else if(i==1)
            return 1;
        else return array(i-1)+array(i-2);
    }

}
