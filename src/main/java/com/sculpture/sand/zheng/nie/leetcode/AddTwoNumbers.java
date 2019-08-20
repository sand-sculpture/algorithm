package com.sculpture.sand.zheng.nie.leetcode;


/**
 * @author: niezheng1
 * @Date: 2019/8/19 14:46
 * <p>
 * 题目：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        r1.next = r2;
        r2.next = r3;
        addTwoNumbers(l1, r1);
    }


    /**
     * 2 4 3
     * 5 6 4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = listNode;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = carry + p1.val + p2.val;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            while (p2 != null) {
                int sum = carry + p2.val;
                carry = sum / 10;
                p2 = p2.next;
                listNode.next = new ListNode(sum % 10);
                listNode = listNode.next;
            }
        }

        if (p2 == null) {
            while (p1 != null) {
                int sum = carry + p1.val;
                carry = sum / 10;
                p1 = p1.next;
                listNode.next = new ListNode(sum % 10);
                listNode = listNode.next;
            }
        }
        if (carry > 0) {
            listNode.next = new ListNode(carry);
        }
        return head.next;
    }

}
