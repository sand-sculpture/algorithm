package com.sculpture.sand.zheng.nie.ai.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author: niezheng1
 * @Date: 2019/8/16 16:05
 *
 * 快拍
 *
 */
public class BubbleSort {




    public static void main(String[] args) {
        int[] arrays = new int[]{1, 3,2, 3, 6, 5};
        BubbleSort(arrays);
        System.out.println(JSON.toJSONString(arrays));
    }


    public static void  BubbleSort(int[] arrays){
        for (int i=0;i<arrays.length;i++){
            for (int j=i;j<arrays.length;j++ ){
                if(arrays[i] > arrays[j]){
                    int temp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
    }

}
