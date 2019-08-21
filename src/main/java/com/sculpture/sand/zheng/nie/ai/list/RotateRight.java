package com.sculpture.sand.zheng.nie.ai.list;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author: niezheng1
 * @Date: 2019/8/21 11:34
 * <p>
 * <p>
 * 1 5 4 6 null      2
 * <p>
 * 1-> 2 -> 3  5
 * <p>
 * <p>
 * 1 -->  2     2-1   1
 * 1 2 3 4 5     2
 *
 * 1 2 null   2 -1 null 1 -2 null  2
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = rotateRight(listNode, 1);
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0 || head.next == null) {
            return head;
        }
        ListNode contNode = head;
        int legth = 0;
        //先统计长度
        while (contNode != null){
            contNode = contNode.next;
            legth++;
        }
        System.out.println("---"+legth);
        if(k>=legth){
            k = k%legth;
        }
        System.out.println("-----k"+k);
        if(k==0){
            return head;
        }
        ListNode index = head;
        //找出切割点
        for(int i = 0; i<k; i++) {
            index = index.next;
        }
        ListNode res = head;
        while (index.next != null){
            index = index.next;
            res = res.next;
        }
        index.next = head;
        ListNode l = res.next;
        res.next = null;
        return l;
    }

}
