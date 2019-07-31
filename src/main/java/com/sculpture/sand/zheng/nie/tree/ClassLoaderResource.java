package com.sculpture.sand.zheng.nie.tree;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author: niezheng1
 * @Date: 2019/7/25 10:49
 */
public class ClassLoaderResource {

    private static final String DUBBO_DIRECTORY = "META-INF/dubbo/com.sculpture.sand.zheng.nie.tree.App";

    public static void main(String[] args) {
        ClassLoaderResource classLoaderResource = new ClassLoaderResource();
        System.out.println(ClassLoaderResource.class.getName());
        System.out.println(classLoaderResource.getClass());
        System.out.println(classLoaderResource.getClass().getClassLoader());
        System.out.println(classLoaderResource.getClass().getClassLoader().getResource(""));
        System.out.println(classLoaderResource.getClass().getClassLoader().getResource("/"));
        System.out.println(JSON.toJSONString(classLoaderResource.getClass().getClassLoader().getResource(DUBBO_DIRECTORY)));
        URL url = classLoaderResource.getClass().getClassLoader().getResource(DUBBO_DIRECTORY);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
