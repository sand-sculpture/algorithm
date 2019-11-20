package com.sculpture.sand.ght.leetcode;

/**
 * @description: 122. 买卖股票的最佳时机 II
 * @author: haitao.gao
 * @create: 2019-09-01 22:36
 */
public class SellingStocks {

    public int maxProfit(int[] prices) {

        Integer sum = 0;

        for(int i =0;i<prices.length;i++){
            if(prices[i+1]>prices[i]){
                if(i==prices.length-1){
                    break;
                }
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }

}
