package jianzhiOffer;

import java.util.*;

public class Solution_42 {
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        // int的最小值
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;

    }

    public int FindGreatestSumOfSubArray_2(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        // 新建动态规划数组
        int[] dp = new int[array.length+1];
        // 由于下方遍历从1开始，先写入第一个数进dp[0]
        dp[0] = array[0];

        // 设置最大值：由于最开始的是array[0]，后面如果是负数肯定更小，如果是整数肯定变大
        int maxSum = array[0];

        for (int i = 1; i < dp.length; i++) {

            dp[i] = Math.max(array[i], array[i]+dp[i-1]);

            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
    }

}
