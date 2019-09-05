package com.sculpture.sand.zheng.nie;

/**
 * @author: niezheng1
 * @Date: 2019/9/3 19:41
 *
 *
 *                          a c b c a
 *                        a
 *                        c
 *                        b
 *                        c
 *                        a
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String reversal = new StringBuffer(s).reverse().toString();
        int[][] cell = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0;i<len;i++){
            for (int j =0;j<len;j++){
                if(reversal.charAt(i) == s.charAt(j)){
                    if(i==0 || j ==0){
                        cell[i][j] = 1;
                    }else {
                        cell[i][j] = cell[i-1][j-1]+1;
                    }
                }
                if(cell[i][j]>maxLen){
                    int before = len-1-i;

                }
            }
        }
        return null;
    }

}
