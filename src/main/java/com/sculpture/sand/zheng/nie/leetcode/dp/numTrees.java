package com.sculpture.sand.zheng.nie.leetcode.dp;

/**
 * @Classname numTrees
 * @Description TODO
 * @Date 2019/11/23 10:50
 * @Created by zheng.nie
 *
 *      思路：
 *          1.定义数组 dp[n] : N个节点组成的二叉树有多少种
 *          2.假设G（n） 为n个节点的二叉树的数量 f(i) 代表以i为根节点的二叉树的数量
 *              则G(n) = f(1)+f(2)+f(3)+.....+f(n)
 *             当i为根节点的时候，左子树的数量为i-1 右子树的数量为n-i 则f(i) = G(i-1) * G(n-i)
 *              则G(n) = G(0)*G(n-i)+G(1)*G(n-2)+....+G(i-1)*G(n-i)
 *          3.确定初始化
 *              n = 1 时 G(1) = 1;
 *              n = 2 时 G(2) = 1
 *
 *
 */
public class numTrees {


    int numTrees(int n) {
        if(n < 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //计算出每个dp[i]的值
        for (int i =2;i<=n;i++){
            //假如有i个节点
            for (int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

}
