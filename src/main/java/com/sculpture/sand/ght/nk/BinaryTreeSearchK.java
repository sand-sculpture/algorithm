package com.sculpture.sand.ght.nk;


/**
 * @description: 二叉搜索树的第k个结点
 *
 *   给定一棵二叉搜索树，请找出其中的第k小的结点。
 *   例如， （5，3，7，2，4，6，8）中，按结点数值
 *   大小顺序第三小结点的值为4。
 * @author: haitao.gao
 * @create: 2019-07-30 20:50
 */
public class BinaryTreeSearchK {


    private Integer total = 0;

    /**
     * DLR--前序遍历（根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面 ）
     *
     * LDR--中序遍历（根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面）
     *
     * LRD--后序遍历（根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面）
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {

        //左节点
        if(pRoot !=null){
            TreeNode node = KthNode(pRoot.left,k);
            //实际上除了满足判断条件其他的情况都是null
            if(node!=null)
                return node;

            //根节点
            total++;
            if(total==k)
                return pRoot;
            //右子树
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;


        }
        return null;

    }

}
