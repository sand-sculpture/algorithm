package com.sculpture.sand.zheng.nie.tree;

import java.util.ArrayList;

/**
 * @author: niezheng1
 * @Date: 2019/7/24 9:19
 *
 *                                             执行
 *                1             target : 7     root -> 1                    1. list : 1,       target : 6
 *              /   \                          root -> 2                   2. list : 1,2      target : 4
 *             2     2                         root -> 2->left  3                    3. list : 1,2,3    target : 1
 *            / \   / \                        root -> 3->left  null        4. return
 *           3   4 3   4                       root -> 3->right null        5. return
 *                                             root -> 4                    6. list:1,2,3,4
 * 题目描述：输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *         路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *         (注意: 在返回值的list中，数组长度大的数组靠前)
 *  思路：使用递归对树遍历，每次将target减去节点值.
 *      递归出口：
 *          1.target值为0 并且树的左子树和右子树都为空
 *          2.递归条件不满足的时候要，清除list里面的最后一个元素
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        //1.记录根节点
        list.add(root.val);
        target = target-root.val;
        if(target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        //删除不符合的节点
        list.remove(list.size() -1);
        return result;
    }

}
