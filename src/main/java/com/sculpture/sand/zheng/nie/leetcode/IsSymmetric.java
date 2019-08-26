package com.sculpture.sand.zheng.nie.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: niezheng1
 * @Date: 2019/8/26 15:06
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return is(root.left, root.right);
    }

    private boolean is(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && is(left.right, right.left) && is(left.left, right.right);
    }


    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;

    }
}
