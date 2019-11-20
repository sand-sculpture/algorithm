package com.sculpture.sand.ght.java.jdk9.PrivateInterface;

public interface Test1 {


    private void testPrivate() {
        System.out.println("接口私有方法执行");
    }

    default void testDefault(){
        System.out.println("接口默认方法执行");
        testPrivate();
    }

    void testPublic();


}
