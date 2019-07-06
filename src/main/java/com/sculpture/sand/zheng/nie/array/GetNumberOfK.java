package com.sculpture.sand.zheng.nie.array;


import org.junit.Test;

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
        int high = getHighIndex(array,k);
        int low = getLowIndex(array,k);
        if(high == -1 || low == -1){
            return 0;
        }
        return high-low +1;
    }


    /**
     * 获取高位下标
     * @param array
     * @param k
     * @return
     */
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
                //防止数组下标越界 以及数组最后一位也为连续数组的情况
                if(( mid < array.length-1)  && array[mid+1] != k  || mid == array.length -1){
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    /**
     * 查询最低下标数组
     * @param array
     * @param k
     * @return
     */
    private int getLowIndex(int[] array,int k){
        int high = array.length -1;
        int low = 0;
        while (low <= high){
            int mid = (high + low)/2;
            if(array[mid] > k){
                high = mid-1;
            }else if(array[mid] < k){
                low = mid+1;
            }else {
                /**
                 * 1.防止数组下标越界 越界条件放在 前面
                 */
                if((mid >0 && array[mid-1] != k ) || mid==0){
                    return mid;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test1(){
        int[] a1 = new int[]{2,3,6,6,6,6,6};
        int high = getHighIndex(a1,6);
        System.out.println(high);
    }

    @Test
    public void test2(){
        int[] a1 = new int[]{2,3,6,6,6,7,8};
        int low = getLowIndex(a1,6);
        System.out.println(low);
    }
}
