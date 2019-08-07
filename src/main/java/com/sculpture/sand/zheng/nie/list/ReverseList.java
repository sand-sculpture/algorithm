package com.sculpture.sand.zheng.nie.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/7 20:55
 *
 * 1->2->3
 *
 *
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode rev = null;
        while (cur!= null){
            rev = cur.next;
            cur.next = pre;
            pre = cur;
            cur = rev;
        }
        return pre;
    }
}
