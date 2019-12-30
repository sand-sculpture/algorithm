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
    6.Bitmaps
        位图
    7.HyperLogLog
    8.GEO
        地理信息定位
####2.redis特性
    1.速度快，读写性能能达到10w/s
        1.1 基于C语言实现
        1.2 使用单线程加购，预防了多线程可能会存在的竞争问题。
    2.基于键值对的数据结构服务器
        redis的值 不仅可以是字符串还可以是具体的数据结构
    3.丰富的功能
        3.1提供键过期功能
        3.2提供订阅发布功能，可以用来实现消息系统
        3.3支持lua脚本，
        3.4提供简单的事务特性
        3.5提供了Pipline功能，这样客户端可以将一批命令一次性传递到redis减少了网络开销。
    4.简单稳定
    5.客户端语言多
    6.持久化
        RDB和AOF
    7.主从复制
    8.高可用和分布式
    高可用实现Redis Sentinel，
            