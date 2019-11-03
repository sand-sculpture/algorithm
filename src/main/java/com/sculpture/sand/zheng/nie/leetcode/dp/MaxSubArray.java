package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @author: niezheng1
 * @Date: 2019/11/3 15:48
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        int res = nums[0];
        int sum = 0;
        for (int num : nums){
            if(sum >0){
                sum = sum+num;
            }else {
                sum = num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }


}
