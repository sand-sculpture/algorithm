#####mysql锁种类
    1.Record Lock ：行锁
    2.Gap Lock：    间隙锁，锁定一个范围，但是不包括记录本身。
    3.Next-Key Lock ： 等于Record Lock + Gap Lock锁定一个范围并且锁定记录本身。
#####mysql加锁原则
    原则一
        加锁的基本单位是next-key lock，前开后闭区间。
    原则二
        查找过程中访问到的对象才进行加锁。
    优化1
        索引上的等值查询，给唯一索引加锁时的时候，next-key lock退化为行锁。
    优化2
        索引上的等值查询，向右遍历时且最后一个值不满足等值条件的时候，next-key lock退化为间隙锁。
      
``
CREATE TABLE `t` (
   `id` int(11) NOT NULL,
   `c` int(11) DEFAULT NULL,
   `d` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `c` (`c`)
  ) ENGINE=InnoDB;
  insert into t values(0,0,0),(5,5,5),
  (10,10,10),(15,15,15),(20,20,20),(25,25,25);
``

 |时刻 | session A | session B | session C  |
 |--- | --------   | -----:   | :----: |
 |t1  |           |            |        |
 
 
    
    

            