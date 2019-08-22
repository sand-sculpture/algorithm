package com.sculpture.sand.ght.leetcode;

/**
 * @description: 198: 打家劫舍
 *
 *    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author: haitao.gao
 * @create: 2019-08-20 21:29
 */
public class FightHome {


    /**
     * 动态规划（result实际上是存的每个该节点的抢夺最大金额）
     *  微积分思想，实际吧整体拆成每一段只用算到每个店铺之前最大数值总和即可，再与前一个节点进行比较
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int[] result = new int[nums.length];
        result[nums.length -1]  = nums[nums.length - 1];

        for(int i = nums.length -2 ; i>=0 ; i--){
            result[i] = Math.max(nums[i]+(i+2>=nums.length?0:result[i+2]),nums[i+1]+((i+3)>=nums.length?0:result[i+3]));
        }
        return result[0];

    }



}
