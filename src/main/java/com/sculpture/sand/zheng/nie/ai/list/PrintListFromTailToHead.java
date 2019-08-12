package com.sculpture.sand.zheng.nie.ai.list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 13:58
 *  题目：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode == null){
            return arrayList;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    /**
     * 使用递归 递归最后的出口就是链表指向为null
     * @param listNode
     * @return
     */

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}
