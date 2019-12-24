package com.example.java;

/**
 * Created by user on 2017/6/20.
 */

public class TestJava {

   private jaa testJava;
    public static void main(String []args){
        int i;
        for (i = 0; i < 10; ++i)
        {
            System.out.println(i);
        }
        int x=0,y=0;
        int p=x++;
        int z=++y;
        System.out.println("x:"+x+" y:"+y+" p:"+p+" z:"+z);
//        test10("14374346, 14374346, 14374346, 14374346");
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

    public static void test10(String str){
        String[] str1 = str.trim().split("\n");
        for(int i=0;i<str1.length;i++){
            try
            {
                Long k=Long.parseLong(str1[i].trim());
                int days = (int)(k / (1000 * 60 * 60 * 24));
                int hours = (int)((k % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                int minutes = (int)((k % (1000 * 60 * 60)) / (1000 * 60));
                int seconds = (int)(k % (1000 * 60)) / 1000;
                String strs= days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + seconds + " 秒 ";
                System.out.println(str1[i].trim()+"  "+"\t"+strs+"\t");
            }catch (Exception e){
                System.out.println(str1[i].trim()+"  "+"\t"+"对应的格式化时间异常");
            }



//            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。
//            String hms = formatter.format(arrys[i]);
        }

    }




}
