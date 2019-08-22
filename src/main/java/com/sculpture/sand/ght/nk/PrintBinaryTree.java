package com.sculpture.sand.ght.nk;

import java.util.ArrayList;

/**
 * @description: 把二叉树打印成多行
 *
 *   从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author: haitao.gao
 * @create: 2019-07-27 13:21
 **/
public class PrintBinaryTree {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();


    /**
     * 层次遍历
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        depth(pRoot,0);
        return result;
    }

    private void depth(TreeNode pRoot, int index) {

        if(pRoot==null){
            return ;
        }
//        if(result.get(index) == null){
//            ArrayList line = new ArrayList();
//            line.add(pRoot.val);
//            result.add(line);
//        }else {
//            result.get(index).add(pRoot.val);
//        }
        //每次判断一下是否存在当前行，初始值是0则最后会空一个出来加大内存
        if(result.size()<index)
            result.add(new ArrayList<>());
        result.get(index).add(pRoot.val);
        depth(pRoot.left,index+1);
        depth(pRoot.right,index+1);
        return;
    }


}
