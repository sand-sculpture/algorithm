package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @Classname nthUglyNumber
 * @Description TODO
 * @Date 2019/12/4 22:41
 * @Created by zheng.nie
 */
public class nthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n<=0){
            return 0;
        }
        int[] dp = new int[n];
        //记录丑数数组中的下标
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        dp[0] = 1;
        for (int i=1;i<n;i++){
            //丑数必定也是乘以2乘以3乘以5来的
            int min = Math.min(dp[index2] * 2,Math.min(dp[index3]*3,dp[index5]*5));
            if(min == dp[index2]*2){
                index2++;
            }
            if(min == dp[index3]*3){
                index3++;
            }
            if(min == dp[index5]*5){
                index5++;
            }
            //丑数按照从小到大一次添加到数组中
            dp[i] =min;
        }
        return dp[n-1];
    }

}
