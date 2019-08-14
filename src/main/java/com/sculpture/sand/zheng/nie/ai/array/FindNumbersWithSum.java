package com.sculpture.sand.zheng.nie.ai.array;

import java.util.ArrayList;

/**
 * @author: niezheng1
 * @Date: 2019/8/13 15:50
 *
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：双指针前后夹击
 */
public class FindNumbersWithSum {


    public static void main(String[] args) {

    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length <2){
            return res;
        }
        int start = 0;
        int end = array.length -1;
        while (start<end){
            if(array[start] + array[end] == sum){
                res.add(array[start]);
                res.add(array[end]);
               return res;
            }else if(array[start] + array[end] >sum){
                end--;
            } else {
                start++;
            }
        }
        return res;
    }

}
