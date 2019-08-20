package com.sculpture.sand.zheng.nie.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @author: niezheng1
 * @Date: 2019/8/19 14:26
 * 题目：给定一个整数数组 nums 和一个目标值
 * target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。*你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arra = new int[]{1,3,5,7};
        int[] ints = twoSum(arra, 4);
        System.out.println(JSON.toJSONString(ints));
    }

    /**
     * 时间复杂度O(n2) 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length<2){
            return null;
        }
        int[] res = new int[2];
        for (int i = 0;i<nums.length;i++){
            int tar = target-nums[i];
            for (int j= i+1;j<nums.length;j++){
                if(nums[j] == tar){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length<2){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i= 0;i<nums.length;i++){
            int other = target-nums[i];
            if(map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
