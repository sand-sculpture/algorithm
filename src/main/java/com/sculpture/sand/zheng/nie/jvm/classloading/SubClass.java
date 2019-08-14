package com.sculpture.sand.zheng.nie.jvm.classloading;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 11:31
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("Subclass init");
    }

}
