package com.sculpture.sand.zheng.nie.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 18:43
 * 题目：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *      例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *  思路：
 *
 */
public class Permutation {


    public static void main(String[] args) {

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length()<=0){
            return result;
        }

        return null;
    }


    public void PermutationHelper(char[] cs,int i,List<String> list){

    }
}
