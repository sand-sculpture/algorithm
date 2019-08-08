package com.sculpture.sand.zheng.nie.ai.tree;

/**
 * @author: niezheng1
 * @Date: 2019/7/22 9:57
 * <p>
 * 题目：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路： 判断树是否对称，使用递归，递归出口
 *      1.左子树和右子树分别为null,返回true
 *      2.左子树或者右子树为null  返回false;
 *      3.左子树和右子树的值相等 并且左子树的右子树 和右子树的左子树相等满足递归条件
 *
 */
public class IsSymmetrical {


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isTree(pRoot.left, pRoot.right);

    }

    public boolean isTree(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isTree(left.left, right.right) && isTree(left.right, right.left);
    }

}
