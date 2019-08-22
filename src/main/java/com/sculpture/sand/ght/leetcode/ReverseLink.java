package com.sculpture.sand.ght.leetcode;

import com.sculpture.sand.ght.nk.ListNode;

/**
 * @description: 反转链表
 * @author: haitao.gao
 * @create: 2019-08-22 21:38
 */
public class ReverseLink {

    public ListNode reverseList(ListNode head) {

        ListNode preNode = null;
        ListNode currentNode = head;

        while (currentNode !=null){

            //取值交换节点
            ListNode tempNode = currentNode.next;
            //把每个当前节点作为第一个节点之前的节点拼接到后面
            currentNode.next = preNode;
            preNode = currentNode;
            // 把最开始链表的下个节点当做循环
            currentNode = tempNode;

        }
        return preNode;

    }

}
