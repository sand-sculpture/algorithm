package com.sculpture.sand.zheng.nie.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: niezheng1
 * @Date: 2019/7/2 9:09
 *
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 *      请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 思路：
 *      1.循环数组，依次用数组值求余数组长度，因为数值的值 是在0 - n-1之间 那么 求余之后的数要是相等 数组中的数就必定相等
 *      2.依次对数组中的数字进行标记+length
 *      3.如果循环到相等数第二次的时候，次数该数组已求余数为下标的值 必定大于length 也必定是第一个相同的数
 *
 */
public class Duplicate {

    /**
     * 思路：先暴力破解 hashSet计数
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(null == numbers || length == 0){
            return false;
        }
        Set set = new HashSet();
        for (int i= 0;i<numbers.length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    /**
     * 解法2
     *        用数组的值求余length
     *        然后标记
     *        如果有求余之后相等的 必定在0-n之间有重复数字
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(null == numbers || length == 0){
            return false;
        }
        for (int i=0;i<numbers.length;i++){
            int index = numbers[i] % length;
            if(numbers[index] >length){
                duplication[0] = numbers[index] -length;
                return true;
            }
            numbers[index] +=length;
        }
        return false;
    }


}
