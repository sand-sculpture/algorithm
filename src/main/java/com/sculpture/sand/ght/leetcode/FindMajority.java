package com.sculpture.sand.ght.leetcode;

import java.util.HashMap;

/**
 * @description: 169. 求众数
 *
 *
 * @author: haitao.gao
 * @create: 2019-09-01 16:12
 */
public class FindMajority {

    HashMap<Integer,Integer> map = new HashMap<>();

    Integer maxNum = 0;

    Integer maxNumber;

    public int majorityElement(int[] nums) {

        if(nums.length ==1){
            return nums[0];
        }
        for (int num : nums) {
            if(map.get(num)!=null){
                map.put(num,map.get(num) + 1);
                //如果发现有最常出现的还多的，就更新最大内容
                if((map.get(num)==null?0:map.get(num))>maxNum){
                    maxNumber = num;
                    maxNum++;
                }
            }else {
                map.put(num,1);
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,2,1,1,1,2,2};
        FindMajority findMajority = new FindMajority();
        findMajority.majorityElement(test);
    }

}
