package com.sculpture.sand.ght.leetcode;

import com.sculpture.sand.ght.nk.TreeNode;

/**
 * @description: 104. 二叉树的最大深度
 * @author: haitao.gao
 * @create: 2019-09-03 20:32
 */
public class TheMaxDepthTree {

    /**
     * 效率太低
     */
//    private int maxDepth =0;
//    public int maxDepth(TreeNode root) {
//
//        findDepth(root,1);
//        return maxDepth;
//    }
//
//    private void findDepth(TreeNode root, int depth) {
//
//        if(root == null){
//            maxDepth = (depth-1)>maxDepth?(depth-1):maxDepth;
//            return;
//        }
//        findDepth(root.left,depth+1);
//        findDepth(root.right,depth+1);
//
//    }

//    public int maxDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }else {
//            int leftDepth = maxDepth(root.left);
//            int rightDepth = maxDepth(root.right);
//            return Math.max(leftDepth,rightDepth)+1;
//        }
//    }

    /**
     * 一行写法
     * @param
     */
    public int maxDepth(TreeNode root) {

        return root ==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

//    public int minDepth(TreeNode root) {
//
//        if(root == null){
//            return 0;
//        }
//        if(root.left ==null){
//            return minDepth(root.right)+1;
//        }
//        if(root.right == null){
//            return minDepth(root.right)+1;
//        }
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//
//        if(leftDepth ==0 || rightDepth ==0){
//            return leftDepth==0?rightDepth:leftDepth;
//        }
//        return Math.min(leftDepth,rightDepth)+1;
//
//    }

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return (leftDepth ==0||rightDepth==0)?leftDepth+rightDepth+1:(Math.min(leftDepth,rightDepth)+1);

    }






    public static void main(String[] args) {
        TheMaxDepthTree tree = new TheMaxDepthTree();
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        tree.maxDepth(root);
    }


}
