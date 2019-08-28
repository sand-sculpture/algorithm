package com.sculpture.sand.zheng.nie.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: niezheng1
 * @Date: 2019/8/28 11:01
 * |——————————————————————|
 * |
 * |——————————————————————
 * <p>
 * 1   1   1   1
 * 2   2   2   2
 * 3   3   3   3
 * 4   4   4   4
 * 思路：
 */
public class SolveNQueens {

    //列
    private Set<Integer> col;
    //斜线
    private Set<Integer> master;
    //反斜线
    private Set<Integer> slave;
    private int n;
    private List<List<String>> res;


    @Test
    public void test1() {
        solveNQueens(4);
    }


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        backtrack(0, stack);
        return res;
    }


    /**
     * 1   1   1   1
     * 2   2   2   2
     * 3   3   3   3
     * 4   4   4   4
     *
     * @param row
     * @param stack
     */
    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }
        //循环判断每行中的每列 是否满足条件
        for (int i = 0; i < n; i++) {
            //不在同一列 不在同一行 不在同一正斜线（常数） 不在同一反斜线（常数）
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);
                //回溯每一行
                backtrack(row + 1, stack);

                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }


}
