package com.sculpture.sand.zheng.nie.jvm;

/**
 * @author: niezheng1
 * @Date: 2019/8/8 20:56
 * 1.栈容量只由-Xss设定
 * 2.异常
 *      2.1 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError
 *      2.2 如果虚拟机在扩展栈是无法申请到足够的内存空间，则抛出OutofMemoryError
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length :"+javaVMStackSOF.stackLength);
            e.printStackTrace();
        }
    }

}
