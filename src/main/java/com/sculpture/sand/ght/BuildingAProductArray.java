package com.sculpture.sand.ght;

/**
 * @description: 构建成绩数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author: haitao.gao
 * @create: 2019-06-27 20:58
 **/
public class BuildingAProductArray {

    public int[] multiply(int[] A) {
        int[] B  = new int[A.length];
        for(int i = 0 ; i<A.length;i++){
            int sum = 1;
            for(int j=0;j<A.length;j++){
                if(i!=j){
                    sum = sum*A[j];
                }
            }
            B[i] = sum;
            sum = 1;
        }
        return B;
    }

    public static void main(String[] args) {

        BuildingAProductArray productArray = new BuildingAProductArray();
        int[] a = new int[5];
        for (int i=1;i<=5;i++){
            a[i-1] = i;
        }
        System.out.print(productArray.multiply(a));
    }

}
