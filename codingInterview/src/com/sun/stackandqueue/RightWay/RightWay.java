package com.sun.stackandqueue.RightWay;

import java.util.Arrays;

public class RightWay {

    public int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur > 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

   public static void main(String[] args) {
       RightWay rw = new RightWay();
       int[] arr = {3,4,1,5,6,2,7};
       for (int[] num : rw.rightWay(arr)) {
           System.out.println(Arrays.toString(num));
       }
   }
}