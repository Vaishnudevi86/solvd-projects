package com.solvd.practice;

import java.util.Arrays;

public class BubbleSort {
    public static void performBubbleSort(int[] array) {
        boolean flag = false;
//i=0
        //{20,80,-2,50,10,5}
        //20, -2, 80, 50, 10, 5
        //20, -2, 50, 80, 10, 5
        //20, -2, 50, 10, 80, 5
        //20, -2, 50, 10, 5, 80
        for (int i = 0; i < array.length; i++) {
            //logger.info("i=" + i);
            for (int j = 1; j < array.length - i; j++) {
               //logger.info("j=" + j);
                if (array[j] < array[j-1]) {
                    //swap;
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
               //logger.info(Arrays.toString(array));
            }
            if ( flag == false) {
                break;
            }

        }
    }
  }





