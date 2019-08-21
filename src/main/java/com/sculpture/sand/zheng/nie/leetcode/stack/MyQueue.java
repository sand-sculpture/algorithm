package com.sculpture.sand.zheng.nie.leetcode.stack;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> outPut = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(outPut.isEmpty()){
            while (!input.isEmpty()){
                outPut.push(input.pop());
            }
        }
      return  outPut.pop();
    }

    public int peek() {
        while (outPut.isEmpty()){
            while (!input.isEmpty()) {
                outPut.push(input.pop());
            }
        }
        return outPut.peek();
    }

    public boolean empty() {
        return input.isEmpty() && outPut.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


