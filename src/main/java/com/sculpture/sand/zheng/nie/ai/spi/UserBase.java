package com.sculpture.sand.zheng.nie.ai.spi;

import lombok.Data;

import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/1 15:23
 */
@Data
public class UserBase {
    /**
     * 男：1 女：2
     */
   private int opdataBaseSex;

    /**
     * 1：15岁以下
     2：16-25岁
     3：26-35岁
     4：36-45岁
     5：46-55岁
     6：56岁以上
     -1：未识别
     */
   private List<Integer> opdataBaseAge;

    /**
     * 省编码
     */
   private List<Integer> opdataBaseProvince;

    /**
     *市区编码
     */
   private List<Integer>  opdataBaseCity;

}
