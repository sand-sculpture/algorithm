package com.sculpture.sand.ght.java.jdk10.var;


/**
 * @description: 引用弱引用类型var
 *
 * 局部变量类型推荐仅限于如下使用场景：
 *
 * 局部变量初始化
 * for循环内部索引变量
 * 传统的for循环声明变量
 * Java官方表示，它不能用于以下几个地方：
 * 方法参数
 * 构造函数参数
 * 方法返回类型
 * 字段
 * 捕获表达式（或任何其他类型的变量声明）
 *
 * @author: haitao.gao
 * @create: 2019-10-12 10:38
 */
public class TestVar {

    public static void main(String[] args) {

        var test1 = "test";
        var test2 = new Integer(1);
        var test3 = new Double(3.23);
        var test4 = new Character('c');
        System.out.println(test1.getClass()+"-"+ test2.getClass()+"-"+test3.getClass()+"-"+test4.getClass());
    }
}
