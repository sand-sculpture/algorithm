package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 14:54
 *
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (list1!= null && list2 != null){
            if(list1.val>=list2.val){
                root.next = list2;
                list2 = list2.next;
                root = root.next;
            }else {
                root.next = list1;
                list1 = list1.next;
                root = root.next;
            }
        }
        //
        if(list1 == null){
            root.next = list2;
        }
        if(list2 == null){
            root.next = list1;
        }
        return head.next;
    }

    /**
     * 递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merg1(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merg1(list1.next,list2);
            return list1;
        }else {
            list2.next = Merg1(list1,list2.next);
            return list2;
        }
    }
}
