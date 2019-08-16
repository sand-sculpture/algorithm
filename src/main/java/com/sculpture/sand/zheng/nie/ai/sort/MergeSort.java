package com.sculpture.sand.zheng.nie.ai.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author: niezheng1
 * @Date: 2019/8/16 14:57
 * 1 3 3 6 5
 * /       \
 * [1 3 3] [6] [5]
 * /   \
 * [1 3] [3]
 * /   \
 * [1]  [3]
 * left 0  mid 0 right 1
 */
public class MergeSort {

    public static void main(String[] args) {
        //left 0 right
        int[] arrays = new int[]{1, 3,2, 3, 6, 5};
        MergeSort(arrays, 0, arrays.length - 1);
        System.out.println(JSON.toJSONString(arrays));
    }


    /**
     *      分治思路 ：
     *              使用递归将将数组分割成单独的一个数，即左下标和右下标相邻的情况。
     *
     * @param arrays
     * @param left
     * @param right
     */
    public static void MergeSort(int[] arrays, int left, int right) {
        //数组中只有一个元素的时候进行合并
        if (left == right) {
            return;
        } else {
            //二分数组 找出分割点
            int mid = (left + right) / 2;
            MergeSort(arrays, left, mid);
            MergeSort(arrays, mid + 1, right);
            merge(arrays, left, mid + 1, right);
        }
    }

    /**
     * @param arrays    合并思路：
     *                          1.根据数组的left mid right 分别对数据进行copy 为两份左数组 和右数组
     *                          2.依次对左数据和右数组的第一个元素依次比较，小的直接更新到array数组中（根据left下标）
     *                          3.根据下标判断左数组和右数组哪个数组有数据剩余，然后进行复制
     *
     *
     *
     * @param left   指向数组的第一个元素
     * @param mid    指向数组分割的元素
     * @param right  指向数组的最后一个元素
     */
    public static void merge(int[] arrays, int left, int mid, int right) {
        //左边数组的大小
        int[] leftArray = new int[mid - left];
        //右边数组的大小
        int[] rightArray = new int[right - mid + 1];
        //将数据复制到左边数组之中
        for (int i = left; i < mid; i++) {
            leftArray[i - left] = arrays[i];
        }
        //将数据复制到右边数组之中
        for (int j = mid; j <= right; j++) {
            rightArray[j - mid] = arrays[j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        //左右数组中的数据进行比较  两个数组的值依次进行比较排序
        while (i < leftArray.length && j < rightArray.length) {
            //左边数组的数据小于右边的
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];
                k++;
                i++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //左边数组的数据没有复制完
        if (i < leftArray.length) {
            while (i < leftArray.length) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            }
        }
        if (j < rightArray.length) {
            while (j < rightArray.length) {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

    }

}
