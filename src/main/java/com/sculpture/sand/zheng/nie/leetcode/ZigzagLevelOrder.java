package com.sculpture.sand.zheng.nie.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: niezheng1
 * @Date: 2019/8/27 11:36
 * 题目：
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            count = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                count--;
                if (isReverse) {
                    level.addFirst(poll.val);
                }else {
                    level.add(poll.val);
                }
            }
            isReverse = !isReverse;
            res.add(level);
        }
        return res;
    }


}
