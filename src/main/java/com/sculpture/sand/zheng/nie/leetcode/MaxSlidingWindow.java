package com.sculpture.sand.zheng.nie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 思路：使用一个队列维护数组窗口的下标；这个队列窗口 最左侧始终是这个窗口的最大值，
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <2 ) {
            return nums;
        }
        LinkedList<Integer> window = new LinkedList<>();
        int[] res = new int[nums.length -k +1];
        for (int i = 0; i < nums.length; i++) {
            //队列的最左端始终维护的是这个窗口的最大值
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]){
                window.pollLast();
            }
            //新元素添加到窗口的最后面
            window.addLast(i);
            //需要 根据下标 判断是否有过期数据存在 3 2 1 1 window.peek():最小的数组下标
            if(k <= i-window.peek()){
                window.poll();
            }
            //判断 窗口是否已经初始化完成了
            if(i+1 >= k){
                res[i-k+1] = nums[window.peek()];
            }
        }
        return res;
    }

}
