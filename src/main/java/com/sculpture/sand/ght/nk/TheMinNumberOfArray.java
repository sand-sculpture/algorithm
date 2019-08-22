package com.sculpture.sand.ght.nk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 * @description: 把数组排成最小的数
 *
 *   输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一
 * 个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @思路： 1.两两比较 2.高位排序
 * @author: haitao.gao
 * @create: 2019-07-10 09:37
 **/
public class TheMinNumberOfArray {

    /**
     * 暴力破解 快速排序直接对比字符串
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {

        ArrayList<String> stringNumber = new ArrayList<>(numbers.length);

        for (int number : numbers) {
            stringNumber.add(String.valueOf(number));
        }

        Collections.sort(stringNumber, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return new String(a+b).compareTo(new String(b+a));
            }
        });
//        System.out.print(stringNumber);
        return stringNumber.toString().substring(1,stringNumber.toString().length()-1).replace(", ","") ;

    }

    /**
     * 比较高位数
     * @param numbers
     */
    public String PrintMinNumberSeconde(int [] numbers) {

        //最大支持十位数比较,组装二维数组
        String[][] a = new String[numbers.length][10];
        for (int i=0;i<numbers.length;i++) {
            String stringNumber = String.valueOf(numbers[i]);
            int index = 0;
            while (stringNumber.length() !=0){
                if(stringNumber.length()==1){
                    a[i][index] = stringNumber;
                    break;
                }else {
                    a[i][index] = stringNumber.substring(0,1);
                    stringNumber = stringNumber.substring(1,stringNumber.length());
                }
                index++;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        TheMinNumberOfArray minArray = new TheMinNumberOfArray();
        int[] a = new int[]{31,1,56,123};
        minArray.PrintMinNumberSeconde(a);
        String tst = "1123";
        System.out.print(tst.substring(1,tst.length()));
    }


}
