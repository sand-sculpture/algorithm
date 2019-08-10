package com.sculpture.sand.zheng.nie.ai.matrix;

import java.util.ArrayList;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 17:02
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * 矩阵的层数：行或者列数最小值-1 (min(m,n)-1)/2+1
 *    1 2
 *    3 4
 *    5
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> reult = new ArrayList<>();
        //数组高度 层数
        int high = matrix.length;
        //每层长度
        int length = matrix[0].length;
        //层数决定最外层打印的次数,获取总层数
        int layers = (Math.min(high, length) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            //1.从左向右打印,开始位置为层数，循环条件小于数组长度减去循环层数 数组下标[层数][k] 结束位置为数组每层长度减去层数
            for (int k = i; k < length - i; k++) {
                reult.add(matrix[i][k]);
            }
            //2.从右上向右下打印 矩阵高度为变量 初始值为层数+1 因为循环1 将矩阵右上数据已遍历 矩阵长度=矩阵原始长度-层数-1
            // 矩阵高度减去层数为数组第二位下标
            for (int m = i + 1; m < high - i; m++) {
                reult.add(matrix[m][length - i - 1]);
            }
            //3.从右下向左下打印 矩阵长度为变量 初始值 = 矩阵原始长度 - 层数 -2（循环2已将矩阵最后一列进行了遍历）
            //循环条件：
            // 矩阵高度为常量 矩阵高度 = 矩阵原始长度-层数-1
            // 数组的长度减去层数然后再减去2
            for (int n = length - i - 2; n >= i && (high - i - 1 != i); n--) {
                reult.add(matrix[high - i - 1][n]);
            }
            //4.从左下上左上打印
            for (int n = high - i - 2; n > i && (length - i - 1 != i); n--) {
                reult.add(matrix[n][i]);
            }
        }

        return reult;
    }

}
