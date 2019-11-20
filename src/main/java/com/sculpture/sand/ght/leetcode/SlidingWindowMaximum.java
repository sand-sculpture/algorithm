package com.sculpture.sand.ght.leetcode;






import java.util.ArrayDeque;
import java.util.ArrayList;


/**
 * @description: 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * @author: haitao.gao
 * @create: 2019-08-24 17:58
 */
public class SlidingWindowMaximum {


    ArrayDeque<Integer> windows ;


    // 其实数组也可以做到
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayList<Integer> result;
        if(nums.length ==0)
            return new int[0];

        result = new ArrayList<>(nums.length);
        windows = new ArrayDeque<Integer>(k);

        for(int i = 0;i<nums.length;i++){
            //判断窗口是否剔除元素
            if(windows.size() !=0 && windows.peek()==i-k){
                windows.removeFirst();
                //把除了第一个之外比我小的都干掉
                while (!windows.isEmpty() && nums[i] > nums[windows.getLast()])                           windows.removeLast();
            }
           windows.add(nums[i]);
            if(i+1>=k){
                result.add(nums[windows.peek()]);
            }
        }
        int[] output = new int[nums.length-k+1];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum mum = new SlidingWindowMaximum();
        mum.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }

}
