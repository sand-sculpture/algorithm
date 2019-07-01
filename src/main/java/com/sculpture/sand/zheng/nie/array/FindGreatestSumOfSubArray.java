package com.sculpture.sand.zheng.nie.array;

/**
 * @author: niezheng1
 * @Date: 2019/7/1 9:29
 *
 *HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {

    /**
     * 动态规划
     *  思路：
     *     F（i）=max（F（i-1）+array[i] ， array[i]）
     *     F(i) 必定是连续的数组和
     * @param array
     */
    public int test1(int[] array){
        if( null == array){
            return 0;
        }
        int max = array[0];
        int res = array[0];
        for (int i = 1;i<array.length;i++){
            //连续数组的最大值
            max = Math.max(max+array[i],array[i]);
            //每次选出最大值
            res = Math.max(max,res);
        }
        return res;
    }


    /**
     *  total 和0进行比较 如果小于0 不利于求和 直接舍弃
     *  total 每次和max进行比较 保证max是最大值
     * @param array
     * @return
     */
    public int test2(int[] array){
        if(null == array){
            return 0;
        }
        int max = array[0];
        int total = array[0];
        for (int i = 1;i<array.length;i++){
            if(total >0){
                total += array[i];
            }else {
                total = array[i];
            }
            if(total > max){
                max = total;
            }
        }
        return max;
    }

}
