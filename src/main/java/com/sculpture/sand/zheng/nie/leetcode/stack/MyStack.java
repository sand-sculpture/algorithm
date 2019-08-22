package com.sculpture.sand.zheng.nie.leetcode.stack;

import java.util.LinkedList;

/**
 * 题目：两个链表实现队列
 *
 * @author: niezheng1
 * @Date: 2019/8/22 9:19
 * <p>
 * <p>
 * 思路：维护两个队列，其中有个队列必定为空，每次入栈的时候 往有数据的队列里面添加元素，每次出栈的时候，
 * 将有数据的队列的前n-1个元素放入另外一个空队列中 然后将q1和q2指针互换。
 *
 *  q1 始终维护有数据的队列
 *
 *     push    1   2  q1 2 1  q2 null
 *     pop            q1 null q2 2  q1 2 q2 null
 *     push    3      3 2
 *
 *  1 2
 */
public class MyStack {

    private LinkedList<Integer> q1 = new LinkedList<>();

    private LinkedList<Integer> q2 = new LinkedList<>();

    private int top;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
        top =x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if(q1.isEmpty() && q2.isEmpty()){
            return 0;
        }

        while (q1.size() > 1) {
            if(q1.size() == 2){
                top = q1.peek();
            }
            Integer remove = q1.remove();
            q2.add(remove);
        }
        //此时q1为空
        int res = q1.remove();
        LinkedList<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}


