package com.sculpture.sand.zheng.nie.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: niezheng1
 * @Date: 2019/8/7 20:11
 * 题目：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 思路：使用队列，队列里面维护数组的下标，队列里面的第一值必定为最大值，如果队列里面的长度超过三个，将队列第一个元素出队列
 * 1. 2
 * 2. 3
 * 3. 4
 * 4. 2 4
 * 5. 6
 *
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if(num == null || num.length == 0 || size <= 0 || num.length < size){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i=0;i<num.length;i++) {
            //队列中保存数组的下标，并且队列中维护滑动窗口的最大值
            while (!linkedList.isEmpty() && num[linkedList.peekLast()] <num[i]){
                linkedList.pollLast();
            }
            linkedList.add(i);
            //判断队列长度是否超过3，队列头是否无效
            if(linkedList.peekFirst() == i-size){
                linkedList.pollFirst();
            }
            //确定队列中的，大于等于滑动窗口的长度时，在进行最大值的返回
            if(i >= size -1){
                result.add(num[linkedList.peekFirst()]);
            }

        }
        return result;
    }


}
