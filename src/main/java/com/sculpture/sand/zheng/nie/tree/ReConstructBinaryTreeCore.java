package com.sculpture.sand.zheng.nie.tree;

/**
 * @author: niezheng1
 * @Date: 2019/8/5 9:27
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * 思路：前序遍历的第一个数为根节点，中序遍历
 */
public class ReConstructBinaryTreeCore {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        };
        TreeNode treeNode = reConstructBinaryTreeCore(pre,in,0,pre.length-1,0,in.length-1);
        return treeNode;
    }


    public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        //前序遍历的第一个为根节点
        TreeNode treeNode = new TreeNode(pre[preStart]);
        treeNode.left = null;
        treeNode.right = null;
        //递归出口
        if (preStart == preEnd && inStart == inEnd) {
            return treeNode;
        }
        int inRoot = 0;
        //在中序数组中查找根节点
        for (inRoot = inStart; inRoot < in.length; inRoot++) {
            if (pre[preStart] == in[inRoot]) {
                break;
            }
        }
        //左子树长度
        int leftLength = inRoot - inStart;
        int rightLength = inEnd - inRoot;
        if (leftLength > 0) {
            treeNode.left = reConstructBinaryTreeCore(pre, in, preStart + 1, leftLength, inStart, inRoot - 1);
        }
        if (rightLength > 0) {
            treeNode.right = reConstructBinaryTreeCore(pre, in, preStart + leftLength + 1, preEnd, inRoot + 1, inEnd);
        }
        return treeNode;
    }
}
