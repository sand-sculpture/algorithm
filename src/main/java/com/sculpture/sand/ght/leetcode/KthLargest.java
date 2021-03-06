package com.sculpture.sand.ght.leetcode;


import java.util.PriorityQueue;

/**
 * @description: 703. 数据流中的第K大元素
 *
 *   设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * @author: haitao.gao
 * @create: 2019-08-24 16:05
 */
public class KthLargest {

    /**
     * 优先队列实际上是小顶堆实现
     * 小顶堆（每个结点的值都小于或等于其左右孩子结点的值）
     * 大顶堆（每个结点的值都大于或等于其左右孩子结点的值）
     */
      PriorityQueue<Integer> record;
      Integer totalSize;
    public KthLargest(int k, int[] nums) {

        this.totalSize = k;
        //初始化大小好像并没有什么卵用啊，及时用了final还是可以无限增加，对于树的大小貌似限制不住
        this.record = new PriorityQueue<Integer>(100000);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(record.size()<totalSize){
            record.offer(val);
        }
        else if(record.peek()<val){
            record.poll();
            record.add(val);
        }
        return record.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);

    }


}
