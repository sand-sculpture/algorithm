package com.sculpture.sand.zheng.nie.leetcode;

/**
 * @author: niezheng1
 * @Date: 2019/8/29 17:04
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
