package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/8/19 11:18
 * 题目：给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class ReverseWords {


    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if(s.trim().equals("")){
            return s;
        }
        String s1 = s.replace("  ", " ");
        System.out.println(s1);
        String[] a = s1.trim().split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }

}
