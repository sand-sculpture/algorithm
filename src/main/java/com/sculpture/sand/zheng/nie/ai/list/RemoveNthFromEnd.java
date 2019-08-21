package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/21 10:03
 *
 *
 * 1-> 2 -> 3-> 4->5  -> 2
 *
 * 0 -> 1 -> 2   2
 *
 * 0 -> 1    1
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null  || n<=0){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode end = pre;
        while (n>0){
            end = end.next;
            n--;
        }
        ListNode start = pre;
        while (end.next != null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return pre.next;
    }

}
