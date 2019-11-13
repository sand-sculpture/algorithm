package com.sculpture.sand.zheng.nie.current;

import java.util.concurrent.TimeUnit;

/**
 * @author: niezheng1
 * @Date: 2019/11/13 17:16
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }



}
