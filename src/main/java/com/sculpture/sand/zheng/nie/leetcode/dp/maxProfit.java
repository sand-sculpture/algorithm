package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @author: niezheng1
 * @Date: 2019/11/26 17:57
 *给定一个数它的第i个元素是一支给定股票第i天的价格
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class maxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        int res = 0;
        for (int  j = 0;j<prices.length;j++){
            for (int i=0;i<prices.length;i++){
                 int temp = prices[i]-prices[j] <0 ?0:prices[i]-prices[j];
                res =Math.min(temp,dp[j][i]);
                dp[j][i] = res;
            }
        }
        return res;
    }

}
