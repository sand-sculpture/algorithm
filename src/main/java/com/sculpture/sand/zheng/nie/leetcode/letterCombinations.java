package com.sculpture.sand.zheng.nie.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: niezheng1
 * @Date: 2019/8/28 14:22
 */
public class letterCombinations {

    List<String> res = new ArrayList<>();

    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mon");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)){
            return res;
        }
        backtrack("",0,digits.toCharArray());
        return res;
    }

    void backtrack(String str, int count, char[] chars) {
        if (chars.length == count) {
            res.add(str);
            return;
        }
        String s = map.get(chars[count]);
        for (int j = 0 ;j<s.length();j++){
           String letter = s.substring(j, j + 1);
            backtrack(str+letter,count+1,chars);
        }
    }


    @Test
    public void test1() {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

}
