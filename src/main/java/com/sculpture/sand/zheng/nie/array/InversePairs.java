package com.sculpture.sand.zheng.nie.array;

/**
 * @author: niezheng1
 * @Date: 2019/7/10 15:57
 * <p>
 * 题目： 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * <p>
 * 思路：
 * 1.使用归并排序将数组进行拆分
 */
public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        //数组复制
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return 0;
    }


    public int inv(int[] array, int[] copy, int low, int high) {

        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = inv(array, copy, low, mid);
        int rightCount = inv(array, copy, mid, high);
        int count = 0;
        //记录分割数组1的高位
        int i = mid;
        //记录分割数组2的高位
        int j = high;
        int copyHigh = high;
        while (i >= low && j> mid){
            //如果数组1的高位大于数组2的高位   那么逆序对的数量就是
            if(array[i] > array[j]){
                count = count+j-mid;

            }
        }

        return 0;

    }

    public static void main(String[] args) {

    }


}
