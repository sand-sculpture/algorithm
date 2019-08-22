package com.sculpture.sand.ght.nk;

import org.junit.Test;

/**
 * @description: 连续子数组的最大和
 *     HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要
 * 计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁
 * 边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返
 * 回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 *用例:
 * [1,-2,3,10,-4,7,2,-5]
 *
 * 对应输出应该为:
 *
 * 18
 *
 * @author: haitao.gao
 * @create: 2019-07-01 22:10
 **/
public class LargestSumOfArray {

    /**
     * 感觉类似于插入排序,缓存最大值
     */
    @Test
    public void FindGreatestSumOfSubArray() {

        int[] array = new int[]{2,8,1,5,9};
        int maxSum = array[0];
        int temp = 0;

        for(int i= 0;i<array.length ;i++){

            if(temp<0){
                temp = array[i];
            }
            else {
                temp = temp + array[i];
            }
            if(temp>maxSum){
                maxSum = temp;
            }
        }

        System.out.print(maxSum);

    }

}
