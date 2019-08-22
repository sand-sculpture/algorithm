package com.sculpture.sand.ght.nk;

import java.util.ArrayList;

/**
 * @description: 从上往下打印二叉树
 *
 *   从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: haitao.gao
 * @create: 2019-07-31 22:19
 */
public class PrintTreeUpToDown {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> tempNode = new ArrayList<>();
        if(root ==null){
            return null;
        }
        tempNode.add(root);
        while (tempNode.size() != 0){
            TreeNode node = tempNode.remove(0);
            if(root.left != null){
                tempNode.add(root.left);
            }
            if(root.right != null){
                tempNode.add(root.right);
            }
            result.add(node.val);
        }

        return result;

    }

//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<TreeNode> queue = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        queue.add(root);
//        while (queue.size() != 0) {
//            TreeNode temp = queue.remove(0);
//            if (temp.left != null){
//                queue.add(temp.left);
//            }
//            if (temp.right != null) {
//                queue.add(temp.right);
//            }
//            list.add(temp.val);
//        }
//        return list;
//    }

}
