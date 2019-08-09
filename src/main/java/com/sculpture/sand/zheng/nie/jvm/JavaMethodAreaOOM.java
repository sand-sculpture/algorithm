package com.sculpture.sand.zheng.nie.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author: niezheng1
 * @Date: 2019/8/8 21:19
 *  CGLib字节码技术，增强的类越多，就需要越大的方法区来保证动态生成的Class可以加载入内存。
 *
 */
public class JavaMethodAreaOOM {


    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,args));
            enhancer.create();
        }
    }

    static class OOMObject{

    }

}
