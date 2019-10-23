package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/10/23 16:14
 * 题目描述：11. 盛最多水的容器
 * 思路：使用双指针 i，j，每次移动短板指针，容器面积才能可能增大 如果移动长指针
 */
public class MaxArea {


    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int s = 0;
        while (i<j) {
            s = height[i] > height[j] ? Math.max(s,(j-i)*height[j--]):Math.max(s,(j-i)*height[i++]);
        }
        return s;
    }
}
