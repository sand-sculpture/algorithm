package com.sculpture.sand.zheng.nie.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/28 16:29
 */
public class GenerateParenthesis1 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n<1){
            return res;
        }
        backtrack(0,0,"",n);
        return res;
    }

    void backtrack(int left,int right, String str,int n){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(left<n){
            backtrack(left+1,right,str+"(",n);
        }
        if(right<left){
            backtrack(left,right+1,str+")",n);
        }
    }


    @Test
    public void test(){
        generateParenthesis(3);
        System.out.println(res);
    }

}
