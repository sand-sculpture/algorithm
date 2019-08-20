package com.sculpture.sand.zheng.nie.jvm;

/**
 * @author: niezheng1
 * @Date: 2019/8/16 17:36
 */
public class Test1 {

    public static void main(String[] args) {
        int k=0;
        long start = System.currentTimeMillis();
        for (int i=0;i<6630000;i++){
            for (int j=0;j<36;j++){
                for (int m=0;m<30;m++){
                    k++;
                }
            }
        }
        long endendTime= System.currentTimeMillis();
        System.out.println(start);
        System.out.println(endendTime);
        System.out.println(endendTime-start);
        System.out.println(k);

    }

}
