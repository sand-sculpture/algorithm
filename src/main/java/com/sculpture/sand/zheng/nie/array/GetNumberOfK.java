package com.sculpture.sand.zheng.nie.array;


/**
 * 题目：统计一个数字在排序数组中出现的次数。
 * 思路：二分查找， 高位下标减去低位下表就是出现的次数
 *
 *
 */
public class GetNumberOfK {


    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        return 0;
    }


    private int getHighIndex(int [] array,int k ){
        int low = 0;
        int high = array.length -1;
        while (low <= high){
            int mid = (low + high) /2;
            if(array[mid] < k){
                low = mid +1;
            }else if(array[mid] > k){
                high = mid-1;
            }else {
                //需要查询出k的最小下标数
                
            }
        }
        return 0;
    }

    private int getLowIndex(int[] array,int k){
        return 0;
    }

}
