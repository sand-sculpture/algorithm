####1.redis支持的数据类型
    1.String 字符串
        编码：raw int embstr
    2.hash 哈希
        hashtable ziplist
    3.list 列表
        linklist ziplist
    4.set 集合
        hashtable intset
    5.zset 有序集合
        skiplist ziplist
     
    
    