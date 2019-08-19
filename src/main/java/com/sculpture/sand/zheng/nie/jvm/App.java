package com.sculpture.sand.zheng.nie.jvm;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/16 17:22
 */
@Data
public class App {


    private Integer age;

    private String name;


    public App(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        HashMap<String,List<App>> app = new HashMap<>();
        List<App> apps = new ArrayList<>();
        apps.add(new App(1,"ss"));
        apps.add(new App(2,"dd"));
        app.put("1",apps);
        System.out.println("appp1---"+ JSON.toJSONString(app));
        List<App> appList = app.get("1");
        System.out.println("apppss---"+JSON.toJSONString(appList));
        appList.add(new App(3,"sssssss"));
        System.out.println("appp1444---"+ JSON.toJSONString(app));


    }

}
