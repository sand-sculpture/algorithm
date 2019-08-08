package com.sculpture.sand.zheng.nie.ai.tree;

import java.util.Stack;

/**
 * @author: niezheng1
 * @Date: 2019/8/1 9:23
 *
 * 题目：给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 二叉搜索树定义：左节点小于根节点，右节点大于根节点
 * 思路：中根遍历的顺序就是从小到大的
 */
public class KthNode {

    /**
     * 树的中序遍历，递归解法
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null ){
            return null;
        }
        //计数器
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        //判断条件兼容叶子节点
        while (pRoot != null || !stack.isEmpty()){
            //左子树全部入栈
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            //返回栈顶元素并将栈顶元素出站
            pRoot = stack.pop();
            count++;
            if(count == k){
                return pRoot;
            }
            //左子树出栈之后，将栈顶的右子树进行入栈
            pRoot = pRoot.right;
        }
        return null;
    }


    /**
     * 树的递归遍历，递归解法
     * @param pRoot
     * @param k
     * @return
     */
//    TreeNode KthNode1(TreeNode pRoot, int k){
//        if(pRoot == null){
//            return null;
//        }
//
//    }
}
