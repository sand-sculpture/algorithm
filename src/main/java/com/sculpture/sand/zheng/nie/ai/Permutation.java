package com.sculpture.sand.zheng.nie.ai;

import java.util.ArrayList;
import java.util.Collections;
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
        Permutation p = new Permutation();
        System.out.println(p.Permutation("abc").toString());
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length()<=0){
            return res;
        }
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    /**
     *
     * @param cs           第一次      cs     i    list
     *                              a b c    0     0
     * @param i
     * @param list
     */
    public void PermutationHelper(char[] cs, int i, List<String> list) {
       if(i == cs.length -1){
           String str=  String.valueOf(cs);
           if(!list.contains(str)){
               list.add(str);
           }
       }else {
           // i : 对第一位进行固定  j : 对下一位进行固定
           for (int j = i ;j<cs.length;j++){
               swap(cs,i,j);
               PermutationHelper(cs,i+1,list);
               swap(cs,i,j);
           }
       }
    }

    public void swap(char[] cs, int i, int j) {
       char temp = cs[i];
       cs[i] = cs[j];
       cs[j] = temp;
    }


}
