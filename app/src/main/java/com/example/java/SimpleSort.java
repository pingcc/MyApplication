package com.example.java;

import java.util.Arrays;

/**
 * Created  on 2018/7/23.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class SimpleSort {

    public static void main(String[] args) {
        SimpleSort simpleSort = new SimpleSort();
        int[] arr = {5, 2, 9, 7, 10, 4, 13};
        System.out.print("从小到大的顺序:" + Arrays.toString(simpleSort.bubbleSort(arr)));

    }

    /**
     * 从前往后比较 从小到大
     */
    public int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
        return arr;
    }


}
