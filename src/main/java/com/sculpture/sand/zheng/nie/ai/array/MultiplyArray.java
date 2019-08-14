package com.sculpture.sand.zheng.nie.ai.array;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author: niezheng1
 * @Date: 2019/6/27 11:31
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 */
public class MultiplyArray {

    /**
     * 时间复杂度O(n^2)
     * @param a
     * @return
     */
    public int[] multiply(int[] a) {
        if(a == null){
            return a;
        }
        int[] b = new int[a.length];
        for(int j=0;j<a.length;j++){
            int sum = 1;
            for (int i=0;i<a.length;i++){
                if(j != i){
                    sum = sum*a[i];
                }
            }
            b[j] = sum;
        }
        return b;



    }

    /**
     * 时间复杂度O(2n)
     */
    @Test
    public void test1 (){

        int [] a = new int[]{1,2,3,4,5};
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1; //属于下三角计算
        /**
         * 下三角计算，从b1 开始计算 从上往下计算 每次新增乘数一个
         * 例如：B1 A0
         *      B2 A0*A1
         */
        for (int i= 1;i<length;i++){
            b[i] = b[i-1]*a[i-1];
        }
        int temp =1;
        /**
         * 上三角计算 从下往上计算
         */
        for (int j=length-2;j>=0;j--){
            temp = temp * a[j+1];
            b[j]  = b[j] *temp;
        }

        System.out.println(JSON.toJSON(b));

    }
}
