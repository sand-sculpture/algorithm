package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @author: niezheng1
 * @Date: 2019/11/18 20:40
 *
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

    思路：
        1.定义数组dp[i][j]
        2.找关系式
            dp[i][j] = min(dp[i-1][j],dp[i][j-1]) +arr[i][j]// arr[i][j]代表数组在这个位置的值
        3.找初始值
            当在第一行或者第一列的时候
                dp[0][j] = arr[0][j]+dp[0][j-1]
                dp[i][0] = arr[i][0] +dp[i-1][0]


 *
 *
 */
public class MinPathSum {


    public int minPathSum(int[][] grid) {
        //列个数
        int n = grid[0].length;
        //行个数
        int m = grid.length;
        if(m<0 || n<0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //第一行初始化
        for (int i =1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //初始化第一列
        for (int j=1;j<m;j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
              dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        //防止越界
        return dp[m-1][n-1];
    }
}
