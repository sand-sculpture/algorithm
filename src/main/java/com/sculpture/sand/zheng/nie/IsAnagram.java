package com.sculpture.sand.zheng.nie;


/**
 * 题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 思路：使用字母的ascll值作为数组的下标进行判断 0- 26 第一个字符串对出现的字符自增，第二个字符串对出现的字符递减
 *
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i =0 ;i<count.length;i++){
            if(count[i]>0){
                return false;
            }
        }
        return true;
    }

}
