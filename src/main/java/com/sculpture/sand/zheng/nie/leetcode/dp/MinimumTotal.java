package com.sculpture.sand.zheng.nie.leetcode.dp;

import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/11/25 19:44
 *
 *
 * https://leetcode-cn.com/problems/triangle/
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 *
 * [
        [2],
      [3,4],
     [6,5,7],
    [4,1,8,3]
]
 *
 *  自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 */
public class MinimumTotal {

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        //size+1的好处时 在计算最底层的时候 不用初始化
      int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for (int i =triangle.size()-1;i>=0;i--){
            List<Integer> rowList = triangle.get(i);
            for (int j = 0;j<triangle.get(i).size();j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+rowList.get(j);
            }
        }
        return dp[0][0];
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        //不用初始化最后一行
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1;i>=0;i--){
            List<Integer> rowList = triangle.get(i);
            for (int j = 0;j<rowList.size();j++){
                //min方法中的dp[j] 每次都是上一行的 dp初始化时size+1进行的初始化第一行
                //每次执行一层循环之后 实际上相当于计算了本行所有的dp[j] 的最小路径
                dp[j] = Math.min(dp[j],dp[j+1]) +rowList.get(j);
            }
        }
        return dp[0];
    }





}
