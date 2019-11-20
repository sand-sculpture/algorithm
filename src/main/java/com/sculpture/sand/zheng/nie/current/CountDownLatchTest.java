package com.sculpture.sand.zheng.nie.current;

import java.util.concurrent.CountDownLatch;

/**
 * @author: niezheng1
 * @Date: 2019/11/19 15:05
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }

}
