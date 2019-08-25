package com.sculpture.sand.zheng.nie.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 题目：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：    1.首先对数组进行排序
 *          2. 每次固定一位，然后用双指针从前后夹逼 如果当前值大于0直接跳出循环 如果当前值有重复 直接跳出循环
 *          3.循环start 指针和 end指针 三数之和0 比较 然后 注意去重
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] param = new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(param);
        System.out.println(JSON.toJSON(lists));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        System.out.println(JSON.toJSON(nums));
        for (int i = 0; i < nums.length; i++) {
            //a > 0直接下次循环
            if (nums[i] > 0) {
                continue;
            }
            //去重
            if ((i > 0) && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                //数组已经过排序了
                if (sum > 0 ) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start<end && nums[start] ==nums[start+1]){
                        start++;
                    }
                    while (start<end && nums[end] == nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }

            }
        }
        return res;
    }

}
