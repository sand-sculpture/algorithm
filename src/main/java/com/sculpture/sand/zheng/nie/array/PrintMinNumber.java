package com.sculpture.sand.zheng.nie.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: niezheng1
 * @Date: 2019/7/9 9:09
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路： c1 = s1 + s2
 *       c2 = s2 + s1
 *       c1 > c2 则 s1 > s2
 *
 */
public class PrintMinNumber {


    @Test
    public String PrintMinNumber( ) {
        int [] numbers = new int[]{2,3,4,5,555};
        if(numbers == null || numbers.length ==0){
            return "";
        }
        String[] str = new String[numbers.length];
        for (int i = 0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
       // System.out.println(JSON.toJSON(str));
        for (int j=0;j<str.length;j++){
            stringBuilder.append(str[j]);
        }
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

}
