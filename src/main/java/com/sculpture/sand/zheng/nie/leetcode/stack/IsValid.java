package com.sculpture.sand.zheng.nie.leetcode.stack;

import java.util.Stack;

/**
 * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 思路：括号成对出现可使用栈  只要出现右括号则必定栈顶元素为左括号 如果栈为空 或者栈顶元素不等于左括号 则不是有效数组
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if(s == null){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<chars.length;i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else if (chars[i] == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }else if(chars[i] == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }else if(chars[i] =='}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
