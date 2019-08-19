package com.sculpture.sand.zheng.nie.ai.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author: niezheng1
 * @Date: 2019/8/16 16:18
 */
public class TreeOrder {


    @Test
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()){
            //左子树全部压栈
            while (root!= null){
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
    }


    public void inOrder(){

    }

}
