package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/10/23 14:46
 *
 * 题目：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 思路：
 *      1.如果是负数 则不是回文数，
 *      2.如果最后一位为0，并且不是0 则不是回文数
 */
public class IsPalindrome {



    public boolean isPalindrome(int x) {
        //负数 和个位数为0的（除了0） 不是回文数
        if(x < 0 || (x%10 ==0 && x != 0)){
            return false;
        }
        int rev = 0;
        //如果是回文数 则会在一半处条件不满足 12321
        while (x > rev){
            rev = rev * 10+x%10;
            x =x/10;
        }
        return x == rev || x == rev/10;
    }
}
