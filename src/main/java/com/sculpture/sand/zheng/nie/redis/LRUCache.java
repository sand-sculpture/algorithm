package com.sculpture.sand.zheng.nie.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: niezheng1
 * @Date: 2020/1/2 14:27
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int CACHE_SIZE;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    /**
     * 此方法为钩子方法，map插入元素时会调用此方法
     * 此方法返回true则证明删除最老的因子
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }



}
