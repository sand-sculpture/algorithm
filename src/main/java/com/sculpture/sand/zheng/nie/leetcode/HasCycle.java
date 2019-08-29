package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/8/29 17:54
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null ){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
