package com.sculpture.sand.zheng.nie.ai.str;

/**
 * @author: niezheng1
 * @Date: 2019/8/13 18:24
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 思路：使用char字节的assci值作为数组的下标，然后每次对数组的值进行自增 hash思路
 */
public class FirstAppearingOnce {


    private  StringBuffer s=new StringBuffer();

    private int[] hashtable = new int[256];


    public void Insert(char ch) {
        s.append(ch);
        hashtable[ch]++;
    }

    public char FirstAppearingOnce() {
        char[] chars = s.toString().toCharArray();
        for (int i=0;i<chars.length;i++){
            if(hashtable[chars[i]] == 1){
                return chars[i];
            }
        }
        return '#';

    }

    public static void main(String[] args) {
        char s ='z';
        System.out.println((int)s);
    }

}
