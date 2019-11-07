package com.sculpture.sand.zheng.nie.thread;

/**
 * @author: niezheng1
 * @Date: 2019/11/7 10:24
 *
 * yield方法会让当前线程从运行状态变为就绪状态，CPU在下次选择中 可能会继续选到当前线程
 *
 *            sleep()和yield()的区别：sleep使线程进入停滞状态，执行sleep的线程在指定时间呢不会被执行 yield方法只是让当前线程重新回到可执行状态，
 *            执行yield方法的线程可能在变成可执行状态的
 *
 */
public class ThreadYield extends Thread {

    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }

    }


    public static void main(String[] args) {
        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");
        yt1.start();
        yt2.start();
    }
}
