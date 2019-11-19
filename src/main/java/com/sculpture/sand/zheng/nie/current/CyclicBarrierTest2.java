package com.sculpture.sand.zheng.nie.current;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: niezheng1
 * @Date: 2019/11/19 15:34
 */
public class CyclicBarrierTest2 {


    static CyclicBarrier c = new CyclicBarrier(2, new A());

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

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }


}
