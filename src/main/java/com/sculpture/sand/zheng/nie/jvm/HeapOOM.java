package com.sculpture.sand.zheng.nie.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author: niezheng1
 * @Date: 2019/8/8 20:42
 *
 * 注：
 *  xms：堆最小值
 *  xmx:堆最大值
 *  xms和xmx值设置为一样可避免自动扩展，
 * -XX:+HeapDumpOnOutOfMemoryError 可让虚拟机在出现内存异常异常时Dump出当前的内存堆转储快照
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
