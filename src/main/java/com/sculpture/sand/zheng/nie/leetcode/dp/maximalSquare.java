package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @Classname maximalSquare
 * @Description TODO
 * @Date 2019/12/3 22:31
 * @Created by zheng.nie
 */
public class maximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length ==0){
            return 0;
        }
        //dp[i][j]代表在数组ij位置的正方形最小边长 +1 可以不用初始化
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int len = 0;
        for (int i = 1;i<=matrix.length;i++){
            for (int j = 1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    //记录等到当前位置的最小正方形边长
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                    //记录最大正方形变成
                    len = Math.max(dp[i][j],len);
                }
            }
        }
        return len*len;
    }

}
