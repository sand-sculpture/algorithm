package com.sculpture.sand.ght.leetcode;

import com.sculpture.sand.ght.nk.TreeNode;

import java.util.*;

/**
 * @description: 102. 二叉树的层次遍历
 * @author: haitao.gao
 * @create: 2019-09-02 22:02
 */
public class BinaryTreeLevelOrder {

//    HashMap<Integer,List<Integer>> resultMap = new HashMap<>();
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        traversingTree(root,1);
//        for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()) {
//            result.add(entry.getValue());
//        }
//        return result;
//    }
//
//    private void traversingTree(TreeNode root, Integer index) {
//
//        if(root == null){
//            return;
//        }
//        if(resultMap.get(index)==null){
//            List<Integer> level = new ArrayList<>();
//            level.add(root.val);
//            resultMap.put(index,level);
//        }else {
//            resultMap.get(index).add(root.val);
//        }
//        traversingTree(root.left,index+1);
//        traversingTree(root.right,index+1);
//    }


    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }


    /**
     * 时间更快的写法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

}
