package com.sculpture.sand.zheng.nie.ai;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 10:42
 * 题目：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 思路：ASCII 0-127 共128位数字
 * A-Z 65 -  90
 * a-z 97 - 122
 * 新建char数组长度 26-6-26 = 58
 *
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str)) {
            return -1;
        }
        //0-57分别代表字符 数组中的值代码字符出现的次数
        int[] words = new int[58];
        //每个字符的hash其实是不变的，作为数组的index 然后每次循环对数组中的值进行自增
        for (int i = 0; i < str.length(); i++) {
            words[(int) str.charAt(i) - 65] += 1;
        }
        //找出数组中第一个值为1的坐标
        for (int j = 0; j < str.length(); j++) {
            if (words[(int) str.charAt(j) - 65] == 1) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char s = 'a';
        System.out.println((int) s);
    }

}
