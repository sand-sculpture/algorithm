package com.sculpture.sand.zheng.nie.jvm.gc;

/**
 * @author: niezheng1
 * @Date: 2019/8/9 10:21
 */
public class ReferenceCountingGC {

    public Object instance = null;

    public static final int _1MB = 1024*1024;

    public byte[] bigSize = new byte[2 * _1MB];


    public static void main(String[] args) {
        ReferenceCountingGC obja = new ReferenceCountingGC();
        ReferenceCountingGC objb  = new ReferenceCountingGC();
        obja.instance = objb;
        objb.instance = obja;
        obja = null;
        objb = null;
        System.gc();
    }


}
