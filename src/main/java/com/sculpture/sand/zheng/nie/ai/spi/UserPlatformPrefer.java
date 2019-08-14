package com.sculpture.sand.zheng.nie.ai.spi;

import java.util.List;

/**
 *
 * @author: niezheng1
 * @Date: 2019/8/2 10:51
 */
public class UserPlatformPrefer {

    /**
     * 大促偏好
     * 4：非常高
     3：高
     2：中
     1：低
     */
    private List<Integer> bigSalePrefer;

    /**
     * 促销敏感度
     * 5：极度敏感

     4：高度敏感

     3：中度敏感

     2：轻度敏感

     1：不敏感

     -1（未识别）
     */
    private List<Integer> sensPromotion;

}
