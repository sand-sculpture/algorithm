package com.sculpture.sand.zheng.nie.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/29 17:22
 */
public class CombinationSum {

    List<List<Integer>> lists = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        back(0,target,candidates,new ArrayList());
        return lists;
    }

    public void back(int start, int target, int[] candidate , ArrayList<Integer> res) {
        if(target == 0){
            lists.add(new ArrayList<>(res));
            return;
        }
        if(target <0){
            return;
        }
        for (int i = start;i<candidate.length;i++){
            res.add(candidate[i]);
            back(i,target-candidate[i],candidate,res);
            res.remove(res.size()-1);
        }
    }

    @Test
    public void test(){
        int[] array = new int[]{2,3,6,7};
        combinationSum(array,7);
        System.out.println(lists);
    }

}
