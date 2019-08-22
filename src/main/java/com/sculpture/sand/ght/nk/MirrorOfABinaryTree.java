package com.sculpture.sand.ght.nk;

/**
 * @description: 二叉树的镜像
 *    操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *    输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @author: haitao.gao
 * @create: 2019-07-23 22:25
 **/
public class MirrorOfABinaryTree {

    public void Mirror(TreeNode root) {
        changeNode(root);
    }

    private void changeNode(TreeNode root) {

        if(root==null ||root.left == null && root.right == null){
            return;
        }

        TreeNode tempNode = null;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        changeNode(root.right);
        changeNode(root.left);
    }


}
