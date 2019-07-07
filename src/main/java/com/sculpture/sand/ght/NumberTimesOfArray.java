package com.sculpture.sand.ght;

/**
 * @description: 数字在排序数组中出现的次数
 *
 *   统计一个数字在排序数组中出现的次数。
 *
 *
 * @author: haitao.gao
 * @create: 2019-07-07 16:18
 **/
public class NumberTimesOfArray {


    /**
     * @思路： 二分法，先找最左边的数字，当找到存在目标数组的分区后不算缩进边界值来确定边界范围
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {

        if(array==null ||array.length==0){
            return 0;
        }

        int firstNo = findFirst(array,k);
        int endNo = findEnd(array,k);

        return endNo -firstNo +1;
    }

    private int findEnd(int[] array, int k) {

        int start = 0,end = array.length -1;
        int mid = (start + end)/2;

        while (start<=end){
            //看中间数如果大于检查右边数组
            if(array[mid]<=k){
                start = mid +1;
            }else {
                end = mid-1;

            }
            mid = (start + end)/2;
        }
        return end;
    }

    private int findFirst(int[] array, int k) {

        int start = 0,end = array.length - 1;
        int mid = (start+end)/2;

        while (start<=end){
            //看中间数如果小于查询左边
            if(array[mid]<k){
                start = mid+1;
            }else {
                end = mid-1;
            }
            mid = (start + end)/2;
        }

        return start;
    }

    public static void main(String[] args) {

        NumberTimesOfArray array = new NumberTimesOfArray();
        int[] a = new int[]{2,2,2,3,3,4,5,5,6,6,7,7,7,7,7,7,8};
        System.out.print(array.GetNumberOfK(a,7));
    }



}
