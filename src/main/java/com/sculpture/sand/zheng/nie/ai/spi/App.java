package com.sculpture.sand.zheng.nie.ai.spi;

import java.lang.reflect.Method;

/**
 * @author: niezheng1
 * @Date: 2019/7/24 10:01
 */
public class App {

    public static void main(String[] args) {
        Test test = new Test();
        Class classa  = test.getClass();
        Method[] methods = classa.getMethods();
      //  System.out.println(JSON.toJSONString(methods));
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }

}
