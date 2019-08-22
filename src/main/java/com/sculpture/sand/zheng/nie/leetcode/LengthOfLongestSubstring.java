package com.sculpture.sand.zheng.nie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: niezheng1
 * @Date: 2019/8/19 16:05
 *
 * 题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思路：a s b c d e a f g h k l
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end = 0,start = 0;end<n;end++){
            char a = s.charAt(end);
            if(map.containsKey(a)){
                start = Math.max(map.get(a),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }

}
