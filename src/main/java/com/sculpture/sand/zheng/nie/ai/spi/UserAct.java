package com.sculpture.sand.zheng.nie.ai.spi;

import lombok.Data;

import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/1 16:14
 */
@Data
public class UserAct {

    /**
     *最后访问店铺时间
     */
    private Long lastVisitTm;

    /**
     * 店铺无访问
     */
    private Long notVisitTm;

    /**
     * 店铺最后关注时间
     */
    private Long lastFollowTm;

    /**
     * 近多少天店铺无关注
     */
    private Long notFollowTm;

    /**
     * 店铺有加购:选定自然日内，加购过本店铺商品的消费者
     */
    private Long lastCartTm;

    /**
     * 店铺无加购：选定自然日内，未加购过本店铺商品的消费者
     */
    private Long notCrtTm;

    /**
     * 最近90天内加购的sku列表
     */
    private List<Long> cartSkus;

    /**
     * 店铺有购买：最近一次购买时间（完成时间）
     */
    private Long  shopLastOrdTm;

    /**
     * 最近多少天无下单
     */
    private Long notLastOrdTm;

    /**
     * 最后关注店铺内商品的时间
     */
    private Long lastFollowSkuTm;

    /**
     *最近成交时间
     */
    private Long shopLastCompleteTm;

    /**
     * 最大成交次数
     */
    private Long maxShopCompleteOrdNum;

    /**
     * 最大成交次数
     */
    private Long minShopCompleteOrdNum;

    /**
     *最大成交金额
     */
    private Long maxShopCompleteOrdAmount;

    /**
     * 最小成交金额
     */
    private Long minShopCompleteOrdAmount;

    /**
     * 最大客单价
     */
    private  Long maxShopAtv;
    /**
     * 最小客单价
     */
    private Long minShopAtv;

    /**
     * 会员等级
     */
    private List<Integer> shopMemberLevel;

    /**
     * 店铺积分最小值
     */
    private Integer minShopPoints;

    /**
     * 店铺积分最小值
     */
    private Integer maxShopPoints;

    /**
     * 是否关注店铺：1.是 0否
     */
    private Integer shopFollowFlag;



}
