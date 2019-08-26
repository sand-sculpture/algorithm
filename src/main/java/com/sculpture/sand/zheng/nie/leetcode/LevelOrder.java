package com.sculpture.sand.zheng.nie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: niezheng1
 * @Date: 2019/8/26 15:49
 *
 * 思路：使用队列每次对二叉树左右节点进行存储
 *      注意：层次遍历需要有个每层数量的计数器 这个计数器的大小等于队列的size
 *
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count;
        while (!queue.isEmpty()){
          count = queue.size();
          List<Integer> list = new ArrayList<>();
          while (count>0){
              TreeNode poll = queue.poll();
              if(poll.left != null){
                  queue.add(poll.left);
              }
              if(poll.right != null){
                  queue.add(poll.right);
              }
              count--;
              list.add(poll.val);
          }
          res.add(list);
        }
        return res;
    }

}
