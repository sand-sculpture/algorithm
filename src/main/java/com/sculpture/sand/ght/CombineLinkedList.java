package com.sculpture.sand.ght;

/**
 * @description: 合并两个排序的链表
 *
 *    输入两个单调递增的链表，输出两个链表合成后的链表，当然
 * 我们需要合成后的链表满足单调不减规则。
 * @author: haitao.gao
 * @create: 2019-08-20 20:39
 */
public class CombineLinkedList {

    public ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        // 每次只是求出当前两个的排序，小的一方往后加一若是为空这自动把另外的队列当前的节点开始赋值给小的一方，若是不为空则则继续比较这两个节点大小
        if(list1.val<=list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }

    }


}
