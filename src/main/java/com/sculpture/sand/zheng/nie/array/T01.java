package com.sculpture.sand.zheng.nie.array;


import org.junit.Test;

/**
 * @author: niezheng1
 * @Date: 2019/6/27 11:31
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 */
public class T01 {

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

    @Test
    public void test1 (int[] a){
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1; //属于下三角计算
        //下三角计算，从b1 开始计算
        for (int i= 0;i<length;i++){
            b[i] = b[i]*a[i];
        }
    }
}
