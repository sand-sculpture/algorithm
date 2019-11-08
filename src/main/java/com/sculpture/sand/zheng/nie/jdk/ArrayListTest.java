package com.sculpture.sand.zheng.nie.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/11/6 15:16
 */
public class ArrayListTest {


    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("a");
        arrayList.add("a");
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == "a") {
                arrayList.remove(i);
            }
        }
        System.out.println(arrayList);
    }

}
