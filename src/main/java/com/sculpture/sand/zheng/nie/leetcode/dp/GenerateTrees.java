package com.sculpture.sand.zheng.nie.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenerateTrees
 * @Description TODO
 * @Date 2019/11/24 11:20
 * @Created by zheng.nie
 *
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if(n<0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        //从i到依次作为根节点
        for (int i =start;i<=end;i++){
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);
            for (TreeNode leftTree:leftTrees){
                for (TreeNode rightTree : rightTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    res.add(node);
                }
            }
        }
        return res;
    }

}
