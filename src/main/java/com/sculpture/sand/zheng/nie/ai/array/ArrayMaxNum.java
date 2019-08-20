package com.sculpture.sand.zheng.nie.ai.array;

/**
 * @author: niezheng1
 * @Date: 2019/8/19 10:18
 *
 * 动态规划三个重要概念
 *          1.最优子结构，
 *          2.边界
 *          3.状态转移公式
 *
 * 思路：每次判断当前值和前两个值之间的关系。
 *
 */
public class ArrayMaxNum {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,5,6,2};

    }

    public static int max(int[] nums){
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            res[i] = Math.max(nums[i]+res[i-2],res[i-1]);
        }
        return res[nums.length-1];
    }


}
