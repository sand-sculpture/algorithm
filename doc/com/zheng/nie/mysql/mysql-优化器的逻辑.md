####1.优化器的逻辑
    1.1 优化器会根据扫描行数，并且结合是否使用临时表，是否排序等因素进行综合判断。
    1.2 优化器扫描行数的判断
        1.优化器根据统计信息来估算记录数，统计信息就是索引的区分度，一个索引上的不同值越多
            这个索引的区分度就越好，一个索引上不同值的个数，我们称为基数，也就是说基数越大
            索引的区分度越好。
    1.3 索引基数的查看
    1.4 mysql 统计索引的基数
        1.采样统计：InnoDB默认会选择N个数据页，统计这些页面的不同值，得到一个平均值，然后乘以这个索引的页面数，就得到这个索引的基数。        
    