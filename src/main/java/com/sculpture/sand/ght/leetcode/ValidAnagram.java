package com.sculpture.sand.ght.leetcode;

import java.util.HashMap;

/**
 * @description: 242. 有效的字母异位词
 * @author: haitao.gao
 * @create: 2019-08-25 17:24
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> record = new HashMap(s.length());

        if(s.length() != t.length()){
            return  false;
        }

        for (char c : s.toCharArray()) {
            if(record.get(c) == null){
                record.put(c,1);
            }else {
                record.put(c, record.get(c) + 1);
            }
        }

        for (char c : t.toCharArray()) {
            Integer num = record.get(c);
            if(num == null){
                return false;
            }else {
                if(num-1 == 0){
                    record.remove(c);
                }else {
                    record.put(c,num-1);
                }
            }
        }

        if(record.isEmpty()){
            return true;
        }else {
            return false;
        }


    }

}
