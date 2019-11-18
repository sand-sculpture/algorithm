package com.sculpture.sand.zheng.nie.dp;

/**
 * @author: niezheng1
 * @Date: 2019/11/18 19:50
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


动态规划解题思路：
        1.定义数组含义，一维数据或者二维数组如题dp[m][n]
        2.找出关系数组元素间的关系式
            dp[m][n] = dp[m-1][n]+dp[m][n-1];\
        3.找出初始值



 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m<0|| n <0){
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i=0;i<m;i++){
            paths[i][0] = 1;
        }
        for (int j=0;j<n;j++){
            paths[0][j] =1;
        }
        for (int i=1;i<m;i++){
            for (int j = 1;j<n;j++){
                paths[i][j] = paths[i-1][j]+paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }


}
