package com.sculpture.sand.ght;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 数组中只出现一次的数字
 *
 *   一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *   异或： 相同为0，相异为1.任何数异或0都为它本身体
 *
 * @author: haitao.gao
 * @create: 2019-07-03 21:14
 **/
public class OnceOfNumberInArray {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int temp = 0;

        // 异或数组内所有数字最后得到的是
        for(int i = 0 ;i<array.length;i++){
            temp^=array[i];
        }

        //找到两个不同数字从右往左数第一个不同的二进制位，在循环查找时可以根据第一位将不同数字遍历到不同数组
        int index = 0;
        while ((temp&1)==0 && index<32){
            temp>>=1;
            index++;
        }

        //同一位一样的数字处理单独的那个其他一定是成对存在，其主要目的是将两个不同且单独的数字分开
        for(int i = 0;i<array.length;i++){
            if((array[i]>>index&1)==1){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }

    public static void main(String[] args) {

        OnceOfNumberInArray array = new OnceOfNumberInArray();
        int[] b = new int[1];
        int[] c = new int[1];
        int[] a = new int[]{2,3,1,1,5,5,6,6,9,9};
        array.FindNumsAppearOnce(a,b,c);


    }

    /**
     * @思考： 若是存在三个单独的数字怎么办？
     *
     * @想法一： 使用两位默认数来将数字分开
     */

}
