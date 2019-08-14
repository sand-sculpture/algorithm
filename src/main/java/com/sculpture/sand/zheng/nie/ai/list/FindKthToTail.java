package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 14:31
 *
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * 思路：链表可以先走K个节点长度，然后使用两个指针记住位置，
 *
 * 1-> 2 -> 5 -> 6-> 7->9       3
 *                              2 2
 *                              5 1
 *
 *                          1        5
 *                          2  6
 *                          5 7
 *                          6 9
 *
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(k<=0 || head == null){
            return null;
        }
        ListNode lastNode = head;
        while (k>1){
            lastNode = lastNode.next;
            k--;
            if(lastNode ==null){
                return null;
            }
        }
        ListNode firstNode = head;
        while (lastNode.next != null){
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        return firstNode;
    }

}
