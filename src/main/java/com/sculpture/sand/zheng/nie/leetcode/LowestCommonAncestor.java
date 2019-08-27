package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @Classname LowestCommonAncestor
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @Date 2019/8/26 21:58
 * @Created by zheng.nie
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

}
