package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/8/27 14:44
 * 题目： 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 思路：使用递归
 *          递归出口：前序数组的左指针小于前序数组的右指针 || 中序数组的左指针小于中序数组的右指针
 *         递归函数
 *              每次在中序数组中寻找与前序数组的第一个数相等的坐标 然后再去递归调用 前序数组和中序数组
 *
 * <p>
 * 1
 * /  \
 * 2    3
 * <p>
 * pre 1 2 3
 * in  2 1 3
 *
 * 前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
 *
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return bulid(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode bulid(int[] pre, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {

        if(preStart>preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int i = inStart;
        while (i<=inEnd && inOrder[i] != pre[preStart]){
            i++;
        }
        root.left = bulid(pre, preStart+1, preStart+i-inStart, inOrder, inStart, i -1);
        root.right = bulid(pre, preStart+i-inStart+1, preEnd, inOrder, i + 1, inEnd);
        return root;
    }

}
