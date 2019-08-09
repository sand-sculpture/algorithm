package com.sculpture.sand.zheng.nie.jvm;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 21:19
 *
 *
 */
public class JavaMethodAreaOOM {


    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            //enhancer.set
        }
    }

    static class OOMObject{

    }

}
