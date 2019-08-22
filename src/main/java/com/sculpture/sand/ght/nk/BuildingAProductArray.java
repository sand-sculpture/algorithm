package com.sculpture.sand.ght.nk;

import org.junit.Test;

/**
 * @description: 构建成绩数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 *用例:
 * [1,2,3,4,5]
 *
 * 对应输出应该为:
 *
 * [120,60,40,30,24]
 *
 * @author: haitao.gao
 * @create: 2019-06-27 20:58
 **/
public class BuildingAProductArray {

    /**
     * 暴力破解 遍历整个二维数组
     * @param A
     * @return
     */
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

    /***
     *  两个倒三角在计算乘积时不断累加减少循环增加效率
     *  实际上只是计算两个三角形面积
     */
    @Test
    public void multiply2(){

        int[] A = new int[]{1,2,3,4,5};
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i = 1;i<A.length;i++){
            B[i] = B[i-1]*A[i-1];
        }

        int temp = 1;
        for(int j= A.length-2;j>=0;j--){
            temp = temp*A[j+1];
            B[j] = B[j]*temp;
        }
        for (int i : B) {
            System.out.print(i + " ");

        }
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
