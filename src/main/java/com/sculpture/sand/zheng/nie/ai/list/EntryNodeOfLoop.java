package com.sculpture.sand.zheng.nie.ai.list;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 16:14
 * 题目：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 思路：
 * 快慢指针
 * 推导结果 从链表起点到环入口等于 环长度减去环入口到相遇点的位置
 * 1.判断链表是否有环
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //链表长度不小于3
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //判断快慢是否相遇 相遇必定有环存在，链表指向为空已判断 以及 链表指向是否为空 来判断是否有环
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                //快指针每次走两步
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //如果指向为null 必定无环
                return null;
            }
        }
        //相遇点已经获取 从链表初始的地方到环入口等于 从相遇点到环入口
        ListNode start = pHead;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return slow;
    }

}
