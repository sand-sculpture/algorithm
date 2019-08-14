package com.sculpture.sand.zheng.nie.ai.list;

import java.util.LinkedList;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 15:20
 *
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：分三步
 *      1.链表中添加新元素 先不处理兄弟节点 例如：A-> B -> C -> D   ------>    A->A'->B->B'->C->C'->D->D'
 *      2.根据旧节点的兄弟节点初始化新节点的兄弟节点
 *      3.将链表进行分割
 */
public class RandomList {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null ){
            return null;
        }
        RandomListNode currentNode = pHead;
        //链表中新增链表，但是不初始兄弟节点
        while (currentNode != null){
            RandomListNode coneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            coneNode.next = nextNode;
            currentNode.next = coneNode;
            currentNode = nextNode;
        }
        currentNode = pHead;
        //初始化兄弟节点
        while (currentNode != null){
          currentNode.next.random =currentNode.random == null?null:currentNode.random.next;
          currentNode = currentNode.next.next;
        }
        //拆分链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}
