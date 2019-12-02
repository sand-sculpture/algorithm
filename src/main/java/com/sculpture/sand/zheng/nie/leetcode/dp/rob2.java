package com.sculpture.sand.zheng.nie.leetcode.dp;

import java.util.Arrays;

/**
 * @author: niezheng1
 * @Date: 2019/12/2 20:11
 */
public class rob2 {


    public int rob(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        //相当于0-->n-1 和 1---->n 两个单排队列进行比较  选了第一个房间就不能选择最后一个房价  选了最后一个房间就不能选择第一个房价
        return Math.max(getRob(Arrays.copyOfRange(nums,0,nums.length-1)),getRob(Arrays.copyOfRange(nums,1,nums.length)));


    }

    private int getRob(int[] nums){
        int pre = 0;
        int cur = 0;
        int temp ;
        for (int num : nums){
            temp = cur;
            //相当于 dp[i] = dp[i-1] 和 nums[i] + dp[i-2]进行比较
            cur = Math.max(pre+num,cur);
            pre = temp;
        }
        return cur;
    }


}
