package com.sculpture.sand.ght.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author: haitao.gao
 * @create: 2019-08-22 22:48
 */
public class Validparentheses {

    //常规接发
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> allStack = new Stack<>();


        for (int i=0;i<s.length();i++){
            Character tempChar = s.charAt(i);
            if(map.containsValue(tempChar)){
                allStack.push(tempChar);
            }else if(map.containsKey(tempChar)){
                if(allStack.empty() || !allStack.peek().equals(map.get(tempChar))){
                    return false;
                }else {
                    allStack.pop();
                }
            }else {
                return false;
            }
        }

        if(!allStack.empty()){
            return false;
        }
        return true;
    }

//    public boolean isValid2(String s) {
//
//        Integer index = s.length();
//        do{
//            s = s.replace("()","").replace("[]","").replace("{}","");
//            index --;
//        }while (index>0);
//        if(s.length()==0){
//            return true;
//        }else {
//            return false;
//        }
//    }



}
