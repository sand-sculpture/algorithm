package com.sculpture.sand.zheng.nie.current;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: niezheng1
 * @Date: 2019/11/19 15:12
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }

}
