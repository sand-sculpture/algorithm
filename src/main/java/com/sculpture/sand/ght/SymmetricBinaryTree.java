package com.sculpture.sand.ght;

/**
 * @description: 对称二叉树
 *
 *    请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: haitao.gao
 * @create: 2019-07-23 20:45
 **/
public class SymmetricBinaryTree {

    boolean isSymmetrical(TreeNode pRoot){

        if(pRoot ==null){
            return true;
        }

        return compare(pRoot.left,pRoot.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {

        if(left==null) return right==null;
        if (right == null) return false;
        if(left.val != right.val) return false;
        return compare(left.right,right.left)&&compare(left.left,right.right);
    }

}
