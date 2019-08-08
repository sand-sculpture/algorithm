package com.sculpture.sand.zheng.nie.ai.spi;

/**
 * @author: niezheng1
 * @Date: 2019/7/25 10:42
 *
 * Class.getResources()和
 * classLoader.getResources()区别
 */
public class ResourceTest {

    private static final String DUBBO_DIRECTORY = "META-INF/dubbo/";

    public static void main(String[] args) {
        System.out.println(ResourceTest.class.getResource(""));
        System.out.println(ResourceTest.class.getResource("/"));
    }

}
