package com.sculpture.sand.zheng.nie.leetcode.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: niezheng1
 * @Date: 2019/8/22 11:45
 *
 *                         1
 *                       /   \
 *                      2     3
 *                     / \   / \
 *                    4   5 6   7
 *              inoder : 4 2 5 1 6 3 7
 *
 *                                                                                 4 2 5 1
 *                  1
                    \
                    2
                    /
                    3
 *
 */
public class InorderTraversal {

    /**
     * 中序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while ( treeNode !=null || !stack.isEmpty()){
            while (null != treeNode){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            arrayList.add(treeNode.val);
           treeNode = treeNode.right;
        }
        return arrayList;
    }

}
