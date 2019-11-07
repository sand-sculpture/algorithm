package com.sculpture.sand.zheng.nie.thread;

/**
 * @author: niezheng1
 * @Date: 2019/11/7 10:08
 *
 *
 * 线程的join方法：暂停调用该线程的线程，等待当前线程完成之后 再执行调用该线程的线程
 *  join方法不影响当前正在运行中的方法
 *
 *
 */
public class Thread1 extends Thread {
    private String name;
    public Thread1(String name) {
        super(name);
        this.name=name;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
//        Thread1 mTh1=new Thread1("A");
//        Thread1 mTh2=new Thread1("B");
//        mTh1.start();
//        mTh2.start();
//        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
//    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");

    }


}
