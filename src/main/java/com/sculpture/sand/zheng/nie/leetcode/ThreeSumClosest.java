package com.sculpture.sand.zheng.nie.leetcode;

import java.util.Arrays;

/**
 * @author: niezheng1
 * @Date: 2019/10/23 17:00
 * 题目：https://leetcode-cn.com/problems/3sum-closest
 * <p>
 * 思路：暴力破解法 需要N的三次方
 * 1.首先进行排序 nlogn
 * 2.使用双指针
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        //每次固定一位 比较其他两位
        for (int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length-1;
            while (start < end){
                int res = nums[i]+nums[start]+nums[end];
                if(Math.abs(target-ans) > Math.abs(target-res)){
                    ans =res;
                }
                //如果目标值小于三数之和 end--
                if(target < res){
                    end--;
                    //目标值大于三数之和 start++
                }else if(target > res){
                    start++;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }

}
