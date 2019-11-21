package com.sculpture.sand.ght.leetcode;

import com.sculpture.sand.ght.nk.TreeNode;

import java.util.ArrayList;

/**
 * @description: 验证搜索二叉树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。

 *
 * @author: haitao.gao
 * @create: 2019-08-25 20:33
 */
public class VerificationBinarySearchTree {

    TreeNode preNode = null;


    /**
     * 中序遍历(一)
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        Boolean isBST = traversingTree(root);
//      return isBST;
//    }
//
//    private boolean traversingTree(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        if(root.left ==null && root.right == null){
//            if(preNode != null){
//                if(preNode.val>=root.val){
//                    return false;
//                }else {
//                    preNode = root;
//                    return true;
//                }
//            }else {
//                preNode = root;
//                return true;
//            }
//        }
//
//        Boolean isBST = traversingTree(root.left);
//        if(!isBST){
//            return isBST;
//        }
//        if(preNode != null){
//            if(preNode.val >= root.val){
//                return false;
//            }
//            preNode  = preNode.val>=root.val?preNode:root;
//        }else {
//            preNode = root;
//        }
//        isBST = traversingTree(root.right);
//        if(!isBST){
//            return isBST;
//        }
//        return true;
//    }


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        VerificationBinarySearchTree tree = new VerificationBinarySearchTree();
        tree.isValidBST(root);
    }

}
