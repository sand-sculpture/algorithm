##1.行锁的释放
    行锁是在需要的时候才加上的，但是不是不需要就立刻释放，都是在事务结束的时候才释放的，这个就是两阶段锁协议。
##2.两阶段锁协议的应用
    如果一个事务的执行过程中需要锁多个行，要把最可能造成锁冲突 最可能影响并发度的锁尽量往后放。
###3.mysql的死锁和死锁检测
    死锁：并发系统中不同线程出现循环资源等待，涉及的线程都在等待别的线程释放资源时，就会导致
        这几个线程都进入无线等待的状态。
    mysql对应死锁策略：
        1.一直等待 直到超时 超时时间参数
            innodb_lock_wait_timeout
        2.发起死锁检测
            发现死锁后，主动回滚锁链条中的某一事务，让其他事务得以执行，设置参数
             innodb_deadlock_detect = on 表示开启逻辑。每个事务被锁的时候，
             就要看他所依赖的线程有没有被别人锁住，
        
    mysql热点更新导致的性能问题，死锁检测需要需要耗费大量的CPU资源
        1.确保业务不会出现死锁，可以临时关掉死锁检测
        2.另一种思路 控制并发度