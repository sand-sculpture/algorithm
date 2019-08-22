package com.sculpture.sand.ght.nk;

/**
 * @description: 重建二叉树
 *
 *   输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输
 *入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3
 *,8,6}，则重建二叉树并返回。
 * @author: haitao.gao
 * @create: 2019-08-05 22:41
 */
public class ReBuildBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        TreeNode treeNode = reBuildTree(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    //题目本身未提供其他内容最好不要使用，还有就是内存使用，直接拨动指针就行
    private TreeNode reBuildTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn;i<endIn;i++) {
            if(in[i] == pre[startPre]){
                root.left = reBuildTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reBuildTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }


}
