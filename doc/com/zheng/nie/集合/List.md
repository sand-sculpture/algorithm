#####ArrayList
    1.底层实现是数组
    2.ArrayList默认初始化容量是10，每次扩容时候增加原先容量的一半，变为原来的1.5倍
    3.在增删的时候，需要数组的copy复制
#####LinkList
    1.底层实现是双向链表[双向链表方便往前遍历]
#####Vector
    1.底层实现是数组，被ArrayList已替代
        1.1 Vector所有方法都是同步，有性能损失
        1.2 Vector初始长度时10，超过length时，以100%比率增长，相对于ArrayList更多消耗内存。
######总结
    查询多用ArrayList 增删多用LinkedList
    1.ArrayList的增删慢不是绝对的，
        1.如果增加的元素一直使用add的时候，一直添加在末尾 那么还是ArrayList更快
        2.一直删除的是末尾的元素，还是ArrayList更快，不用复制移动位置
        3.如果删除的是中间位置的话还是ArrayList要快