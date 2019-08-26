package com.sculpture.sand.zheng.nie.leetcode;

import java.util.Stack;

/**
 * @Classname IsValidBST
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @Date 2019/8/26 21:30
 * @Created by 86181
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        double pre = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

}
