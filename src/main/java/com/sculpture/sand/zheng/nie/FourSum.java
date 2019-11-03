package com.sculpture.sand.zheng.nie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/11/3 10:20
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i>0 &&nums[i] == nums[i -1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j>(i+1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (start > (j + 1) && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < (nums.length - 1) && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                    }else if(sum < target){
                        start++;
                    }else {
                        end--;
                    }
                }

            }
        }
        return res;
    }


}
