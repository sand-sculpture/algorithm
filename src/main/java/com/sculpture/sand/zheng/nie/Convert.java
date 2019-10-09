package com.sculpture.sand.zheng.nie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** 题目：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * @author: niezheng1
 * @Date: 2019/9/5 20:36
 */
public class Convert {

    // LEETCODEISHIRING

    public String convert(String s, int numRows) {
       if(numRows <2){
           return s;
       }
        List<StringBuffer> row = new ArrayList<>();
       for (int i=0;i<numRows;i++){
           //记录行层数
           StringBuffer buffer = new StringBuffer();
           row.add(buffer);
       }
       int i = 0;
       int flag = -1;
       for (char item : s.toCharArray()){
            row.get(i).append(item);
            if(i ==0 || i == numRows-1){
                flag = -flag;
            }
            i+= flag;
       }
       StringBuilder stringBuilder = new StringBuilder();
       for (StringBuffer stringBuffer : row){
            stringBuilder.append(stringBuffer);
       }
       return stringBuilder.toString();
    }

    @Test
    public void test(){
        String s = convert("LEETCODEISHIRING", 3);
        System.out.println(s);
    }

}
