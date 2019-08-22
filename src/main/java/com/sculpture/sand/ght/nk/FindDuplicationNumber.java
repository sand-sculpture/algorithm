package com.sculpture.sand.ght.nk;

/**
 * @description: 数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是
 * 重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出
 * 数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}
 * ，那么对应的输出是第一个重复的数字2。
 *
 *
 * @author: haitao.gao
 * @create: 2019-07-02 22:05
 **/
public class FindDuplicationNumber {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * @思路： 确认考点是使用最小内存，因为只涉及一维数组所以时间复杂度没有很大的差别
     *         反而占用额外空间大小是优化关键。
     *         常规操作将遍历过的数存放新集合在不断检索，优化关键是在于将新集合合并到
     *         原来的集合中，但又不影响原来集合查询。
     *
     * @注意： 边界值 左开右闭
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        for(int i = 0;i<length;i++){
            //实际上是在设置标记位置，证明这个数字已经遍历过了，
            // 因为不可能存在比lenght更大的数据
            //在求余的过程中也在寻找遍历过的数字
            int index = numbers[i]%length;
            if(numbers[index]>=length){
                duplication[0] = index;
                return true;
            }

            //加上长度等于标记该数字已经遍历过，只要存在大于长度的数那么那个数的余数的字段就会大于lenght
            numbers[index] = numbers[index]+length;
        }
        return false;

    }

}
