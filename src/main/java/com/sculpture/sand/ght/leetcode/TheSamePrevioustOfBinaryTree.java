package com.sculpture.sand.ght.leetcode;

import com.sculpture.sand.ght.nk.TreeNode;

/**
 * @description: 236. 二叉树的最近公共祖先
 * @author: haitao.gao
 * @create: 2019-08-28 07:24
 */
public class TheSamePrevioustOfBinaryTree {


    /**
     *  主要思想就是递归每一个节点，查看左右子树是否有目标节点， 如果两边都有的话说明该节点是公共节点，要是一边存在
     *  任何一个说明两个元素都在某一个子树，因为是递归所以实际上是从下往上遍历。（递归思想，重复相同的步骤，缩小范围）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return root;
        }

        if(root ==q || root ==p){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!= null){
            return root;
        }

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }
        return root;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        if(root == null || root ==q || root ==p){
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//
//        return left == null? right : right == null?left:root;
//    }


}
