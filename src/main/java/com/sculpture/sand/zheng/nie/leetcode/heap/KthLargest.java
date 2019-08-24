package com.sculpture.sand.zheng.nie.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 维护
 *
 */
public class KthLargest {

    private PriorityQueue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        Arrays.stream(nums).forEach(this::add);
    }

    public int add(int val) {
        //首先判断 堆中的元素数量是否小于k 如果小于k 则直接添加
        if(queue.size() < k){
            queue.offer(val);
            //和堆顶元素进行比较 如果大于堆顶元素 则 堆顶出堆 再题添加新的元素
        }else if(queue.peek() <val){
            //如果不小于 首先先将堆顶元素出堆
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

}
