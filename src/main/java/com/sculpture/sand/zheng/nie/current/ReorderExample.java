package com.sculpture.sand.zheng.nie.current;

/**
 * @author: niezheng1
 * @Date: 2019/11/12 16:30
 */
public class ReorderExample {

    int a = 0;
    boolean flag = false;
    public void writer() {
        a = 1; // 1
        flag = true; // 2
    }
    public void reader() {
        if (flag) { // 3
            int i = a * a; // 4
        }
    }



}
