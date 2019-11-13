package com.sculpture.sand.zheng.nie.current;

/**
 * @author: niezheng1
 * @Date: 2019/11/13 17:35
 *
 * ！！！在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑。
 *
 *
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }


}
