package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/21 17:46
 *  1 2 2 2 3
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode pre = new ListNode(0);
        pre.next = start;

        ListNode end = head.next;
        while (end != null){
            if(start.val != end.val){
                start = end;
                head.next = start;
                head = head.next;
                end = end.next;
            }else {
                end = end.next;
                while (start.val != end.val && end.next != null){
                  head.next = end;
                  head = head.next;
                  start = end;
                  end = end.next;
                }
            }
        }
        return pre.next;
    }

}
