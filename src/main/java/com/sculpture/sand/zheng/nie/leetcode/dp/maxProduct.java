package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @Classname maxProduct
 * @Description TODO
 * @Date 2019/11/28 21:51
 * @Created by zheng.nie
 */
public class maxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        //记录以当前节点为终结节点的连续子序列的最大值
        int imax = 1;
        //记录以当前节点为终结点的连续子序列的最小值
        int imin = 1;
        for (int i =0;i<nums.length;i++){
            if(nums[i] < 0){
                //当当前节点为负数的时候，imax和imin互换
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }

}
