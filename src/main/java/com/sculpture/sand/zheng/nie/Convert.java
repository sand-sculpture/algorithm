package com.sculpture.sand.zheng.nie;

import org.junit.Test;

/**
 * @author: niezheng1
 * @Date: 2019/9/5 20:36
 */
public class Convert {

    // LEETCODEISHIRING

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i<numRows;i++){
            buffer.append(chars[i]);
            int j =i+numRows+1;
            while (j<chars.length){
                buffer.append(chars[j]);
                j = j+numRows+1;
            }
        }
       return buffer.toString();
    }

    @Test
    public void test(){
        String s = convert("LEETCODEISHIRING", 3);
        System.out.println(s);
    }

}
