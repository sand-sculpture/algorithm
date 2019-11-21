package com.sculpture.sand.ght.java.jdk9.PrivateInterface;

/**
 * @description:
 * @author: haitao.gao
 * @create: 2019-10-06 17:52
 */
public class Test1Impl implements Test1 {

    @Override
    public void testPublic() {
        System.out.println("测试公共方法");
    }

    public static void main(String[] args) {
        Test1Impl test1  = new Test1Impl();

        test1.testPublic();
        test1.testDefault();
    }
}
