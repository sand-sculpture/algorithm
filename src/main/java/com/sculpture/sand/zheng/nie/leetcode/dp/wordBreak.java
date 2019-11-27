package com.sculpture.sand.zheng.nie.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: niezheng1
 * @Date: 2019/11/27 10:07
 */
public class wordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> stringSet = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for (int  i= 1;i<=s.length();i++){
            for (int j = 0;j<i;j++){
                if(dp[j] && stringSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
