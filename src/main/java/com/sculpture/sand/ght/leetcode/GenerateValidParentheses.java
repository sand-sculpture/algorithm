package com.sculpture.sand.ght.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * @author: haitao.gao
 * @create: 2019-09-03 22:40
 */
public class GenerateValidParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        genAndCheck(result,"",n,n);
        return result;
    }

    private void genAndCheck(List<String> result,String subString, int left, int right) {
        if(left>right){
            return;
        }
        if(left>0){
            genAndCheck(result,subString+"(",left-1,right);
        }
        if(right>left){
            genAndCheck(result,subString+")",left,right-1);
        }
        if(left == 0 && right == 0){
            result.add(subString);
            return;
        }
    }

}
