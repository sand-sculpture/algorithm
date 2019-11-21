package com.sculpture.sand.ght.leetcode;

/**
 * @description: Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * @author: haitao.gao
 * @create: 2019-09-01 10:55
 */
public class Pow {

    public double myPow(double x, int n) {

        if(n==1){
            return x;
        }
        if(n==-1){
            return 1/x;
        }

        if(n==0){
            return 1.00;
        }

        return fastPow(n>0?x:1/x,n>0?n:-n);
    }

    private double fastPow(double x, int n) {

        if(n==0){
            return 1.00;
        }
        double halfSum = fastPow(x,n/2);
        if(n%2==0){
            return halfSum*halfSum;
        }else {
            return halfSum*halfSum*x;
        }
    }
}
