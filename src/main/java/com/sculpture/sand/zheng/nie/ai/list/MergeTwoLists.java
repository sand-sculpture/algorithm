package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/21 10:46
 * <p>
 * l1   1 2 4             5
 * l2   1 3 4             1 2 4
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mrgeNode = new ListNode(0);
        ListNode head = mrgeNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return mrgeNode.next;
    }



}
