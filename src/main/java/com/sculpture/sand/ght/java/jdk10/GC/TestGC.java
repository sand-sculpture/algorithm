package com.sculpture.sand.ght.java.jdk10.GC;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @description: 测试GC
 *
 *   GC改进和内存管理
 * 新增两个专门用来改进当前垃圾收集元素：
 * 1.JEP304 引入了一个纯净的垃圾收集器接口，帮助改善不同垃圾收集器之间的代码隔离；
 * 2.JEP307 针对G1收集器的完全GC过程，通过完全GC并行来改善STW时间，改接口主要目标是使G1平行
 *
 *
 * @author: haitao.gao
 * @create: 2019-10-30 10:40
 */
public class TestGC {


    public static void main(String[] args) {

        String test = new String("我是强引用");
        SoftReference<String> sr = new SoftReference<String>(new String("我是软引用"));
        WeakReference<String> wr = new WeakReference<String>(new String("我是软引用"));
        System.out.println(test+","+sr.get()+","+wr.get());
        System.gc();
        System.out.println(test+","+sr.get()+","+wr.get());

    }

}
