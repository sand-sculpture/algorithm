package com.sculpture.sand.ght.nk;

import java.util.ArrayList;

/**
 * @description: 调整数组顺序使奇数位于偶数前面
 *
 *   输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位
 * 于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶
 * 数之间的相对位置不变。
 * @author: haitao.gao
 * @create: 2019-08-14 21:17
 */
public class SortArrayList {

    /**
     * 暴力破解 (实际上快很多，大概快了一倍左右)
     * @param array
     */
    public void reOrderArray(int [] array) {

        ArrayList<Integer> doubleArray = new ArrayList();
        ArrayList<Integer> singleArray = new ArrayList();

        for (int i : array) {
            if(i%2==1){
               doubleArray.add(i);
            }else {
                singleArray.add(i);
            }
        }
        doubleArray.addAll(singleArray);
        for(int i =0;i<array.length;i++){
            array[i] = doubleArray.get(i);
        }
    }

    public static void main(String[] args) {
        SortArrayList sortArrayList = new SortArrayList();
        int[] test = new int[]{1,2,3,4,5,6,7};
        sortArrayList.reOrderArray(test);
    }

}
