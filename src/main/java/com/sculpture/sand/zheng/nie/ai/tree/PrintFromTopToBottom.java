package com.sculpture.sand.zheng.nie.ai.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: niezheng1
 * @Date: 2019/8/13 15:32
 *
 * 题目：层次遍历二叉树 使用队列
 *
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            TreeNode node = linkedList.removeFirst();
            if(node.left != null){
                linkedList.addLast(node.left);
            }
            if(node.right != null){
                linkedList.addLast(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

}
