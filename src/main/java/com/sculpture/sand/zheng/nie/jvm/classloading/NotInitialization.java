package com.sculpture.sand.zheng.nie.jvm.classloading;

/**
 * @author: niezheng1
 * @Date: 2019/8/12 11:32
 *
 * 被动引用1
 * 对于静态字段只有直接定义这个字段的类才会被初始化，
 * 因此通过其子类来引用父类中定义的静态字段 只会触发其父类的初始化 不会触发其子类的初始化。
 *
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}
