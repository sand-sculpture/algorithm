package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/10/23 10:20
 *
 * 题目描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *  思路 依次对数据进行求余翻转 判断溢出的情况 和 大于Integer.MAX_VALUE/10 的情况
 */
public class Reverse {

    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int pop = x % 10;
            //溢出
            if((res > Integer.MAX_VALUE/10) || (res == Integer.MAX_VALUE/10 && pop > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE/10 || ((res == Integer.MIN_VALUE/10) && pop < -8) ){
                return 0;
            }
            res = res*10+pop;
            x = x/10;
        }
        return res;
    }

}
