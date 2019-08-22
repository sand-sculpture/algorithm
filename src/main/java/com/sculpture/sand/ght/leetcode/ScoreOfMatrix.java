package com.sculpture.sand.ght.leetcode;

/**
 * @description: 861. 翻转矩阵后的得分
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * @author: haitao.gao
 * @create: 2019-08-20 22:30
 */
public class ScoreOfMatrix {

    /**
     * 实际上先把最大位全部设置为1，其余为看反转后的大小
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {

        for(int  i = 0;i< A.length;i++){
            if(A[i][0] == 0){
                for(int j = 0;j<A[i].length;j++){
                    A[i][j] = A[i][j] == 0?1:0;
                }
            }
        }
        int sum = 0;
        int index = 1;
        //先遍历列
        for(int k = A[0].length-1;k >=0;k--){

            // 每一列0的个数
            int sumOfZer0 = 0;
            for(int j = 0;j <= A.length;j++){
                if(A[j][k] ==0){
                    sumOfZer0 ++;
                }
            }

            if(sumOfZer0>A.length/2){
                sum = sum + (sumOfZer0 *index);
            }else {
                sum = sum + ((A.length -sumOfZer0) *index);
            }
            index*=2;
        }

        return sum;

    }


}
