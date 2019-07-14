package com.sculpture.sand.ght;

/**
 * @description: 数组中的逆序对
 *
 *    在数组中的两个数字，如果前面一个数字大于后面的数字，则这
 * 两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对
 * 的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author: haitao.gao
 * @create: 2019-07-11 22:45
 **/
public class ReverseOrderInArray {


    /**
     * 冒泡排序 (复杂度太大)
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {

        int sum = 0;
        for(int i = 0;i<array.length;i++){
            for (int j = 0;j<array.length;j++){
                if(array[i]>array[j] && i<j){
                    sum++;
                }
            }
        }

        return sum%1000000007;
    }


    /**
     * 归并排序
     */


//    public int InversePairs2(int [] array) {
//        if(array==null||array.length==0)
//        {
//            return 0;
//        }
//        int[] copy = new int[array.length];
//        for(int i=0;i<array.length;i++)
//        {
//            copy[i] = array[i];
//        }
//        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
//        return count;
//
//    }
//    private int InversePairsCore(int[] array,int[] copy,int start,int end)
//    {
//        if(start==end)
//        {
//            return 0;
//        }
//        int mid = (start  + end)/2;
//        int leftCount = InversePairsCore(array,copy,start,mid)%1000000007;
//        int rightCount = InversePairsCore(array,copy,mid+1,end)%1000000007;
//        int count = 0;
//        int i=mid;
//        int j=end;
//        int locCopy = end;
//        while(i>=start&&j>mid)
//        {
//            if(array[i]>array[j])
//            {
//                count += j-mid;
//                copy[locCopy--] = array[i--];
//                if(count>=1000000007)//数值过大求余
//                {
//                    count%=1000000007;
//                }
//            }
//            else
//            {
//                copy[locCopy--] = array[j--];
//            }
//        }
//        while (i>=start){
//            copy[locCopy--] = array[i--];
//        }
//        while (j>mid){
//            copy[locCopy--] = array[j--];
//        }
//        for(int s=start;s<=end;s++)
//        {
//            array[s] = copy[s];
//        }
//        return (leftCount+rightCount+count)%1000000007;
//    }

    public int InversePairs2(int [] array){

        int start = 0;
        int end = array.length -1;
        int copy[] = new int[array.length];
        for(int i=0;i<array.length-1;i++){
            copy[i] = array[i];
        }
        int resut = getNumber(array,copy,0,array.length -1);
        int sum = resut%1000000007;
        return sum;
    }

    /**
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int getNumber(int[] array, int [] copy, int start, int end) {

        //当数组被
        if(start == end){
            return 0;
        }

        int mid = (end + start )/2;
        int i = mid;
        int j = end;
        int count = 0;
        int endCopy = end;
        int leftCount = getNumber(array,copy,start,mid);
        int rightCount = getNumber(array,copy,mid+1,end);

        while (i>=start&&j>mid)
        {
            if(array[i]>array[j])
            {
                count = count + j - mid;
                copy[endCopy--] = array[i--];
                if(count>1000000007){
                    count = count%1000000007;
                }
            }
            else {
                copy[endCopy--] = array[j--];
            }
        }

        while (i>=start){
            copy[endCopy--] = array[i--];
        }

        while (j<mid){
            copy[endCopy--] = array[j--];
        }

        for (int s = start;s<=end;s++){
            array[s] = copy[s];
        }

        return (leftCount + rightCount + count)%1000000007;

    }

    public static void main(String[] args) {

        ReverseOrderInArray reverseOrderInArray = new ReverseOrderInArray();
        int[] a = new int[]{1,2,3,4,5,0};
        int sum = reverseOrderInArray.InversePairs2(a);
        System.out.print(sum);
    }


}
