package com.sculpture.sand.zheng.nie.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 21:08
 *
 *    -XX:PermSize
 *    -XX:MaxPermSize
 * vm:-XX:PermSize=10M -XX:MaxPermSize=10M
 *    String intern 是一个Native方法，如果常量池中已经包含一个等于String对象的字符串 则返回这个对象
 *      否则将此对象包含的字符串加到常量池中。
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //list中保持常量池的引用，避免FUll GC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }

    }

}
