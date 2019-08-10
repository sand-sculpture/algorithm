package com.sculpture.sand.zheng.nie.ai;

import java.util.ArrayList;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 11:56
 * 题目：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *      但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *      没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 *      Good Luck!
 *      等差数列求和公式：（a0+an）*n/2
 *      例如：9            1 2 3 4 5 6 7 8 9
 *  思路：使用双指针进行 根据等差数列的求和和sum进行比较
 *      1.和等于sum
 *          high 或者low指针自增 然后将low-high 分别存入list中
 *      2.和小于sum
 *          high自增
 *      3.和大于sum
 *          low自增
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum<=0){
            return result;
        }
        int low = 1;
        int high = 2;
        while (low < high){
            int cur = (low + high)*(high-low+1)/2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i= low;i<=high;i++){
                    list.add(i);
                }
                result.add(list);
                high++;
            }else if(cur < sum){
                high++;
            }else {
                low++;
            }
        }
        return result;
    }

}
