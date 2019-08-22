package com.sculpture.sand.ght.nk;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @description: 二叉树中和为某一值的路径
 *
 *   输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值
 * 的和为输入整数的所有路径。路径定义为从树的根结点开始往下
 * 一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的
 * list中，数组长度大的数组靠前)
 *
 * @author: haitao.gao
 * @create: 2019-07-26 16:35
 **/
public class FindPathForTree {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    /**
     *  不懂为什么中间截取运行时间反而比之前还更高
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {


        if(root == null || target<0) return result;
        path.add(root.val);
        target -= root.val;

        if(target==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(path));
            result.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return  String.valueOf(o2.size()).compareTo(String.valueOf(o1.size()));
                }
            });
        }
        FindPath(root.right,target);
        FindPath(root.left,target);
        path.remove(path.size() -1);
        return result;
    }


    public static void main(String[] args) {

    }


}
