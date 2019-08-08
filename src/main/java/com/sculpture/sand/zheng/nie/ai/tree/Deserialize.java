package com.sculpture.sand.zheng.nie.ai.tree;

/**
 * @author: niezheng1
 * @Date: 2019/8/7 19:42
 *  题目：请实现两个函数，分别用来序列化和反序列化二叉树
 *  思路：
 *      序列化：先根遍历，遇到叶子节点添加“#”作为标识， 递归出口 遇到叶子节点为空 添加“#”
 *      反序列化：依次遍历数组 使用递归 递归出口 遇见“#” 返回当前树节点
 *
 *
 */
public class Deserialize {
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if(root == null){
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val+",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        String[] str1 = str.split(",");
        TreeNode node = null;
        if(!str1[index].equals("#")){
            node = new TreeNode(Integer.valueOf(str1[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
