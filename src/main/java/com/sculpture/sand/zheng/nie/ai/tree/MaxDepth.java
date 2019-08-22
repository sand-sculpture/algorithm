package com.sculpture.sand.zheng.nie.ai.tree;

/**
 * @author: niezheng1
 * @Date: 2019/8/20 15:06
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
