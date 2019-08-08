package com.sculpture.sand.zheng.nie.ai.array;

import org.junit.Test;

/**
 * @author: niezheng1
 * @Date: 2019/7/3 9:18
 * <p>
 * 异或 ^：相同为0 相异为1  一个数和零异或还是他本身
 * <p>
 * 与 & ：两个操作数中位都为1，结果才为1，否则结果为0
 * <p>
 * <p>
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * [1,2,4,5,6,7,5,1,2,6]
 * <p>
 * 思路：
 *      1.数组里面的所有数异或的结果等于 两个不相等数的异或结果；
 *      2.根据异或结果求出从低位开始bit位为1的下标数
 *      3.根据下标数可以将数组分割开，其中两个不相等的数必定会被分割为两个数组里面
 *      4.根据分割的结果继续异或就能分别求出两个不相等的数
 */
public class FindNumsAppearOnce {

    /**
     * 异或 相同为0  相异为1  任何数和0异或等于这个数本身
     * <p>
     * 7: 0111
     * 3: 0011
     * 3: 0011
     * <p>
     * 7^3 = 0100
     * 0100^0011 = 01111
     */
    @Test
    public void FindNumsAppearOnce() {
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        if (null == array || array.length < 2) {
            return;
        }
        /**
         * 4 : 0100
         * 6 : 0110
         * 4^6 = 0010; =2
         */
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        System.out.println(result);
        //获取相等的两个数的的二进制为1的位数
        int index = getFirstBit1(result);
        System.out.println(index);
        for (int j = 0; j < array.length; j++) {
            if (isBit1(array[j], index)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }

    }

    /**
     * 获取数组中两个不相同数的异或结果的1的位数
     *
     * @param result
     * @return
     */
    private int getFirstBit1(int result) {
        int index = 0;
        while (index < 32 && ((result & 1) == 0)) {
            //右移位
            result >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 判断数组中的数的第indexbit位是不是为1
     *
     * @param target
     * @param index
     * @return
     */
    private boolean isBit1(int target, int index) {
        return (((target >> index) & 1) == 1);
    }
}
