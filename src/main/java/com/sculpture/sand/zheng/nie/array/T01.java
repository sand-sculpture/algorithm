package com.sculpture.sand.zheng.nie.array;

/**
 * @author: niezheng1
 * @Date: 2019/6/27 11:31
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 */
public class T01 {

    public int[] multiply(int[] a) {
        if(a == null){
            return a;
        }
        int[] b = new int[a.length];
        for(int j=0;j<a.length;j++){
            int sum = 0;
            for (int i=0;i<a.length;i++){
                if(j != i){
                    sum = sum*a[i];
                }
            }
            b[j] = sum;
        }
        return b;



    }
}
